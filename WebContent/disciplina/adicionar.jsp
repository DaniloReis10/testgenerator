<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
				<legend>Adicionar disciplina</legend>
			</fieldset>
			
			<c:if test="${sessionScope.erro != null}">
				<div class="alert alert-dismissible alert-danger">
					<strong>Erro!</strong>
					<c:out value="${sessionScope.erro}"></c:out>
				</div>
				
				<c:remove var="erro" scope="session" />
			</c:if>
			
			<c:if test="${sessionScope.sucesso != null}">
				<div class="alert alert-dismissible alert-success">
					<strong>Sucesso!</strong>
					<c:out value="${sessionScope.sucesso}"></c:out>
				</div>
				
				<c:remove var="sucesso" scope="session" />
			</c:if>
			
			<div class="row">
				<form class="form-horizontal" id="novaDisciplina" action="${pageContext.request.contextPath}/disciplina/adicionar" method="post" enctype="application/x-www-form-urlencoded">
					<div class="form-group">
						<label for="inputNome" class="col-lg-2 control-label">Nome</label>
						<div class="col-lg-10">
							<input type="text" class="form-control" id="inputNome" name="inputNome" placeholder="Nome descritivo da disciplina" value="">
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-lg-12 col-lg-offset-7">
							<button type="submit" class="btn btn-primary">Salvar</button>
							<button type="button" class="btn btn-primary" onclick="window.location = '${pageContext.request.contextPath}/disciplina'">Voltar</button>
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
			$('#novaDisciplina').validate(
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