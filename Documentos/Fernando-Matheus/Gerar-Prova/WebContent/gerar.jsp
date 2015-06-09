<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="javabeans.Topico" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Preencha os campos</title>


    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" text="text/css" href="estilo.css"/>




    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    
    <script>
    function validaQuantidade(){
    	if(document.form.quantidadeQuestoes.value==""){
    		alert("Preecha o campo de quantidade de questões!");
    		document.form.quantidadeQuestoes.focus();
    		return false;
    	}
    }
    </script>
</head>
<body>

				<%
						List<Topico> lista = (List<Topico>)request.getAttribute("lista"); 
						int resp = (int) request.getAttribute("resp");
				%>
				
		<div class="container">
		<br /><br />
			
			
				<form name="form" class="form-horizontal" onSubmit="return validaQuantidade();" action="ControladorProva">
					<div class="col-lg-4"></div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">Quantidade:</label>
								<div class="col-sm-1">
      						<input type="text" class="form-control" name="quantidadeQuestoes">
    							</div>						
						</div>
						<div class="col-lg-4"></div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">Tópicos:</label>
								<div class="col-sm-2">
									 <select class="form-control" id="topico" name="topicos">
                            <%
                            	int cont=1;
                            	for(Topico t : lista){
                            		if(t.getDisciplina_idDisciplina() == resp){
                            	%>
                            	
                            	<option value="<%=t.getNome()%>"><%=t.getNome() %></option>		
                            		
                            	<%
                            		cont++;
                            		} %>
                           
                            <% }%>

                        </select>
								</div>
						</div>
						
						<div class="col-lg-4"></div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">Tipo:</label>
								<div class="col-sm-2">
									<select class="form-control" id="tipo" name="tipos">
                            <option value="discursiva">Discursiva</option>
                            <option value="objetiva">Objetiva</option>
                            <option value="v ou f">V ou F</option>
                            		</select>             
								</div>
						</div>	
						<br/>
						<script>
							function valida(){
								
							}
						</script>	
								
								
						<div class="col-lg-6"></div>
						<div class="form-group">
						<button type="submit" onclick="valida();" class="btn btn-success">Gerar Prova!</button>		
						</div>
				</form>
			
		</div>
		
		
	
	

</body>
</html>
