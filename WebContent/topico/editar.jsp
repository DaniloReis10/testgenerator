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
				<form class="form-horizontal" id="editarTopico" action="${pageContext.request.contextPath}/topico/editar" method="post" enctype="application/x-www-form-urlencoded">
					<div class="form-group">
						<input type="hidden" name="id" value="<c:out value="${requestScope.topico.ID}"></c:out>" />
						<label for="inputDisciplina" class="col-lg-3 control-label">Disciplina</label>
						<div class="col-lg-9">
							<select class="form-control" id="inputDisciplina" name="inputDisciplina">
								<option value="">Selecione...</option>
								<c:forEach var="disciplina" items="${disciplinas}">
									<option <c:if test="${disciplina.ID == requestScope.topico.disciplinaID}"><c:out value="selected=\"selected\""></c:out></c:if> value="${disciplina.ID}"><c:out value="${disciplina.disciplinaNome}"></c:out></option>
								</c:forEach>
							</select>
						</div>
					</div>
					
					<div class="form-group">
						<label for="inputNome" class="col-lg-3 control-label">Nome</label>
						<div class="col-lg-9">
							<input type="text" class="form-control" id="inputNome" name="inputNome" placeholder="Nome descritivo do tópico" value="<c:out value="${requestScope.topico.topicoNome}"></c:out>">
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
		$('#"editarTopico"').validate(
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