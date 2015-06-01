<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="entities.Topico,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<script src="http://code.jquery.com/jquery-1.11.3.min.js" type="text/javascript"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js" type="text/javascript"></script>
<title>Testgenerator - Tópicos</title>
</head>
<body>
	<div class="container">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
			<fieldset>
				<legend>Lista de Tópicos</legend>
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
			
			<a href="${pageContext.request.contextPath}/disciplina" class="right">- Disciplinas</a><br /><br />

			<a href="${pageContext.request.contextPath}/topico/adicionar" class="right">+ Novo tópico</a><br />
			<a href="${pageContext.request.contextPath}/disciplina/adicionar" class="right">+ Nova disciplina</a>

			<div class="row">
				<table
					class="table table-striped table-hover text-center table-bordered">
					<thead>
						<tr>
							<th class="text-center">ID</th>
							<th class="text-center">Disciplina</th>
							<th class="text-center">Tópico</th>
							<th class="text-center">Ações</th>
						</tr>
					</thead>
					<tbody>

						<%
							ArrayList<Topico> topicos = (ArrayList<Topico>) request.getAttribute("topicos");
							if (topicos.size() > 0)
							{
								for (Topico topico : topicos) {
						%>
						<tr>
							<td><%= topico.getID() %></td>
							<td><%= topico.getDisciplinaNome() %></td>
							<td><%= topico.getTopicoNome() %></td>
							<td>
								<a href="${pageContext.request.contextPath}/topico/editar?id=<%= topico.getID() %>">Editar</a>
								<a href="javascript:void(0);" onclick="test.deletar(<%= topico.getID() %>);">Excluir</a>
							</td>
						</tr>
						<%
								} 
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
		<div class="col-lg-4"></div>
	</div>
</body>
</html>

<script type="text/javascript">
	function testgenerator() {
		this.deletar = deletar;
		function deletar(id) 
		{
			var confirmacao = confirm('Tem certeza que deseja deletar este registro?\nEsta ação não poderá ser desfeita.');
			if (confirmacao)
			{
				$.post('${pageContext.request.contextPath}/topico/deletar',
				{
					id: id 
				}, function(a)
				{
					alert(a.msg)
					if (a.status == 1)
						window.location = window.location;
				}, 'json');
			}
				
		}
	}

	var test = new testgenerator();
</script>