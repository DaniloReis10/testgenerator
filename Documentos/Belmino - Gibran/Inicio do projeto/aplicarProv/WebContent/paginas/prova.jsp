<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="dao" class="dao.QuestaoDAO"></jsp:useBean>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
        <title>Realizar prova</title>
        <link rel="stylesheet" href="../resources/css/prova.css">
    </head>
    <body>
		<div class="container">
            <h3>Fazer prova</h3>
            <hr>
			<form action="teste">
		        <a class="btn btn-success finalizar">Finalizar</a>
		        <div class="conteudo">
					<c:forEach var="questao" items="${dao.getQuestoes(param.prova)}" varStatus="conta">
						<div style="display:none" id="q${conta.count }" >
		                <h3><c:out value="${conta.count })${questao.enunciado }" /></h3>
		                <c:forEach var="opcao" items="${questao.opcoes }" varStatus="conta2">
		                	<c:choose>
		                		<c:when test="${questao.tipo == 'M' }">
		                			 <p><input type="radio" value="" name="resposta">   <c:out value="${opcao.enunciado }"/></p>
		                		</c:when>
		                		<c:when test="${questao.tipo == 'V' }">
		                			 <p><input type="checkbox" value="" name="resposta">   <c:out value="${opcao.enunciado }"/></p>
		                		</c:when>
		                		<c:otherwise>
		                			<p><input type="text" value="" name="resposta"></p>
		                		</c:otherwise>
		                	</c:choose>
		                	<p></p>
	                	</c:forEach>
						</div>
	                </c:forEach>				    
		        </div>
			</form>
        <button id="btAnterior" class="btn btn-primary anterior" disabled >Anterior</button>
        <button id="btPosterior" class="btn btn-primary proximo">Próxima</button>
        </div>
	</body>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="../resources/js/prova.js"></script>
</html>

