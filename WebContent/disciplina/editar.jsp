<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="entities.Disciplina,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<script src="http://code.jquery.com/jquery-1.11.3.min.js" type="text/javascript"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js" type="text/javascript"></script>
<title>Testgenerator - Disciplinas</title>
</head>
<body>
	<div class="container">
		<div class="col-lg-4">
		</div>
		<div class="col-lg-4">
			<fieldset>
				<legend>Editar disciplina</legend>
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
			
			<%
				ArrayList<Disciplina> disciplina = (ArrayList<Disciplina>) request.getAttribute("disciplina");
			%>
			
			<div class="row">
				<form class="form-horizontal" id="editarDisciplina" action="${pageContext.request.contextPath}/disciplina/editar" method="post" enctype="application/x-www-form-urlencoded">
					<input type="hidden" name="id" value="<%= disciplina.get(0).getID() %>" />
					<div class="form-group">
						<label for="inputNome" class="col-lg-2 control-label">Nome</label>
						<div class="col-lg-10">
							<input type="text" class="form-control" id="inputNome" name="inputNome" placeholder="Nome descritivo da disciplina" value="<%= disciplina.get(0).getDisciplinaNome() %>">
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
		$('#editarDisciplina').validate(
		{
			rules:
			{
				inputNome: "required"
			},
			messages: 
			{
				inputNome: "Campo obrigatório"
			}
		});
	});
	
	function testgenerator() 
	{
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