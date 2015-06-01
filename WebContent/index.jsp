<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <title>Testgenerator - Home</title>
    </head>
    <body>
		<div class="container">
			<div class="col-lg-4">
			</div>
			<div class="col-lg-4">
				<p>Escolha qual módulo deseja acessar:</p>
				<a href="${pageContext.request.contextPath}/disciplina">Disciplinas</a><br />
				<a href="${pageContext.request.contextPath}/topico">Tópicos</a>
			</div>
			<div class="col-lg-4">
			</div>
		</div>
	</body>
</html>