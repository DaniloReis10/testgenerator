<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="entities.Topico,entities.Disciplina,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<script src="http://code.jquery.com/jquery-1.11.3.min.js" type="text/javascript"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js" type="text/javascript"></script>
<title>Testgenerator - Tópicos</title>
</head>
<body>
	<div class="container">
		<div class="col-lg-4">
		</div>
		<div class="col-lg-4">
			<fieldset>
				<legend>Adicionar tópico</legend>
			</fieldset>
			
			<%
				if (session.getAttribute("erro") != null)
				{ 
			%>
			<div class="alert alert-dismissible alert-danger">
				<strong>Erro!</strong>
				<%= session.getAttribute("erro") %>
			</div>
			<%
					session.removeAttribute("erro");
				}
			%>

			<%
				if (session.getAttribute("sucesso") != null)
				{
			%>
			<div class="alert alert-dismissible alert-success">
				<strong>Sucesso!</strong>
				<%= session.getAttribute("sucesso") %>
			</div>
			<%
					session.removeAttribute("sucesso");
				}
			%>
			
			<div class="row">
				<form class="form-horizontal" id="novoTopico" action="${pageContext.request.contextPath}/topico/adicionar" method="post" enctype="application/x-www-form-urlencoded">
					<div class="form-group">
						<label for="inputDisciplina" class="col-lg-3 control-label">Disciplina</label>
						<div class="col-lg-9">
							<select class="form-control" id="inputDisciplina" name="inputDisciplina">
								<option value="">Selecione...</option>
								<% 
								ArrayList<Disciplina> disciplinas = (ArrayList<Disciplina>) request.getAttribute("disciplinas");
								if (disciplinas.size() > 0)
								{
									for (Disciplina disciplina : disciplinas)
									{
								%>
									<option value="<%= disciplina.getID() %>"><%= disciplina.getDisciplinaNome() %></option>
								<%
									}
								}
								%>
							</select>
						</div>
					</div>
					
					<div class="form-group">
						<label for="inputNome" class="col-lg-3 control-label">Nome</label>
						<div class="col-lg-9">
							<input type="text" class="form-control" id="inputNome" name="inputNome" placeholder="Nome descritivo do tópico" value="">
						</div>
					</div>

					
					<div class="form-group">
						<div class="col-lg-3 col-lg-offset-9">
							<button type="submit" class="btn btn-primary">Salvar</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="col-lg-4">
		</div>
	</div>
</body>
</html>

<script type="text/javascript">
	$(function()
	{
		$('#novoTopico').validate(
		{
			rules:
			{
				inputNome: "required",
				inputDisciplina: "required"
			},
			messages: 
			{
				inputNome: "Campo obrigatório",
				inputDisciplina: "Campo obrigatório"
			}
		});
	});
	
	function testgenerator() {
		this.deletar = deletar;
		
		function deletar() 
		{
			var confirmacao = confirm('Tem certeza que deseja deletar este registro?');
			if (confirmacao)
				alert('Registro removido');
		}
		
	}

	var test = new testgenerator();
</script>