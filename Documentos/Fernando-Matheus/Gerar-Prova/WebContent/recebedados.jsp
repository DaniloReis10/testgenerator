<%@page import="javabeans.QuestaoDissertativa"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="javabeans.QuestaoObjetiva" %>
    <%@ page import="javabeans.Topico" %>
    <%@ page import="javabeans.QuestaoVF" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Prova</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" text="text/css" href="estilo.css"/>
    
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
</head>
<body>

			 <%
				int numeroDeQuestoes = (int) request.getAttribute("questoesInteiro"); //recebendo o numero de questoes
			 	String tipoDaQuestao = (String) request.getAttribute("tipoQuestao"); //recebendo o tipo das questoes
				int codigoTopico = (int) request.getAttribute("numero"); //recendo o numero do topico selecionado no dropdown.
			 	int contDiss=0;
				int contObj=0;
				int numQuestObj = numeroDeQuestoes;
				int contVF=0;
				boolean testeD = false;
				boolean testeO = false;
				boolean testeVF = false;
				
				int numQuestVF = numeroDeQuestoes;
			 	List<QuestaoDissertativa> listaDiss = (List<QuestaoDissertativa>) request.getAttribute("listaDiss");
			 	List<QuestaoObjetiva> listaObj = (List<QuestaoObjetiva>) request.getAttribute("listaObj");
			 	List<QuestaoVF> listaVF = (List<QuestaoVF>) request.getAttribute("listaVF");
				
			%>
			
			<%
			if(tipoDaQuestao.equals("discursiva")){
				
			
			for(QuestaoDissertativa q : listaDiss){
	 			if(q.getTopico_idTopico() == codigoTopico){
	 				contDiss++;
	 			}
	 			
	 		}
			
	 	
		
		if(contDiss >= numeroDeQuestoes){
	%>
		<% for(QuestaoDissertativa q : listaDiss){
			if(q.getTopico_idTopico() == codigoTopico){
				
				%>	
					<center>
					<h4><%=q.getPergunta() %></h4>
					<input type="text" size="10" name="resp">
				</center>
					
				<%
					numeroDeQuestoes--;
					if(numeroDeQuestoes == 0){
						break;
					}
				%>
			
			<%}
			
		}%>
		
		<%}else{
			testeD = true;
		
		}
		}%>
		
		<%
		
		if(tipoDaQuestao.equals("objetiva")){
	 		for(QuestaoObjetiva q : listaObj){
	 			if(q.getTopico_idTopico() == codigoTopico){
	 				contObj++;
	 			}
	 			
	 		}
	 	
		
		if(contObj >= numQuestObj){
	%>
		<% for(QuestaoObjetiva q : listaObj){
			if(q.getTopico_idTopico() == codigoTopico){
				
				%>	
					<center>
					<h4><%=q.getPergunta() %></h4>
					<input type="radio" name="a" value="a"><%=q.getItem_a() %><br/>
					<input type="radio" name="b" value="b"><%=q.getItem_b() %><br/>
					<input type="radio" name="c" value="c"><%=q.getItem_c() %><br/>
					<input type="radio" name="d" value="d"><%=q.getItem_d() %><br/>
					
				</center>
					
				<%
					numQuestObj--;
					if(numQuestObj == 0){
						break;
					}
				%>
			
			<%}
			
		}%>
		
		<%}else{
			testeO = true;
		} 
		}%>
		
		<%
		
		if(tipoDaQuestao.equals("v ou f")){
	 		for(QuestaoVF q : listaVF){
	 			if(q.getTopico_idTopico() == codigoTopico){
	 				contVF++;
	 			}
	 			
	 		}
	 	
		
		if(contVF >= numQuestVF){
	%>
		<% for(QuestaoVF q : listaVF){
			if(q.getTopico_idTopico() == codigoTopico){
				
				%>	
					<center>
					<h4><%=q.getPergunta() %></h4>
					<input type="text" size="1" name="1_vf"><%=q.getItem_1_VF() %><br />
					<input type="text" size="1" name="2_vf"><%=q.getItem_2_VF() %><br />
					<input type="text" size="1" name="3_vf"><%=q.getItem_3_VF() %><br />
					<input type="text" size="1" name="4_vf"><%=q.getItem_4_VF() %><br />
					
				</center>
					
				<%
					numQuestVF--;
					if(numQuestVF == 0){
						break;
					}
				%>
			
			<%}
			
		}%>
		
		<%}else{
			testeVF = true;
		}
		}%>
			
		<%
			if(testeD==true || testeO==true || testeVF==true){
		%>		
			<center><h4>Nao encontramos o numero de questoes solicitado para tal topico</h4>
				<a href="index.html">Inicio</a>
			</center>
			
			<%} %>
		
			
			



</body>
</html>
