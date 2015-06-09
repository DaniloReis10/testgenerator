<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<script src="http://code.jquery.com/jquery-1.11.3.min.js" type="text/javascript"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js" type="text/javascript"></script>
<title>Testgenerator - Disciplinas</title>
</head>
<body>
	<div class="container">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
			<fieldset>
				<legend>Lista de Disciplinas</legend>
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

			
			<a href="${pageContext.request.contextPath}/topico" class="right">- Tópicos</a><br /><br />
			<a href="${pageContext.request.contextPath}/disciplina/adicionar" class="right">+ Nova disciplina</a>

			<div class="row">
				<table
					class="table table-striped table-hover text-center table-bordered">
					<thead>
						<tr>
							<th class="text-center">Disciplina</th>
							<th class="text-center">Ações</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${fn:length(disciplinas) gt 0}">
							<c:forEach var="disciplina" items="${disciplinas}">
								<tr>
									<td><c:out value="${disciplina.disciplinaNome}"></c:out></td>
									<td>
										<a href="${pageContext.request.contextPath}/disciplina/editar?id=${disciplina.ID}">Editar</a>
										<a href="javascript:void(0);" onclick="test.deletar(${disciplina.ID});">Excluir</a>
									</td>
								</tr>
							</c:forEach>
						</c:if>
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
				$.post('${pageContext.request.contextPath}/disciplina/deletar',
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