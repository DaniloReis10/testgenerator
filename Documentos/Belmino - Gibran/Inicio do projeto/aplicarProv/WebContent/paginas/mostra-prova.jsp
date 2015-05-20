<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="dao" class="dao.QuestaoDAO"></jsp:useBean>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
        <title>Prova</title>
    </head>
    <body>
		<div class="container">
            <h3>Lista de provas</h3>
            <hr>
            	<c:forEach var="questao" items="${dao.getQuestoes(param.prova) }" varStatus="conta">
	                <h3><c:out value="${conta.count })${questao.enunciado }" /></h3>
	                <c:forEach var="opcao" items="${questao.opcoes }" varStatus="conta2">
	                	<p><c:out value="${conta2.count })${opcao.enunciado }"/></p>
                	</c:forEach>
                </c:forEach>
                
              
        <a class="btn btn-success" href="prova.jsp?prova=1">Fazer prova</a>
        <a class="btn btn-success" href="../index.jsp">Voltar</a>    
        </div>
        
    </body>
</html>    