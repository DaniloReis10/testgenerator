<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="dao" class="dao.ProvaDAO"></jsp:useBean>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
        <title>Tabela de provas</title>
    </head>
    <body>
    
		<div class="container">
            <h3>Lista de provas</h3>
            <hr>
            <table class="table table-bordered">
                  <thead>
                    <tr>
                        <th>Disciplina</th>
                        <th>Tópico</th>
                        <th>Qtd de questões</th>
                    </tr>
                </thead>
                <tbody>
                               
                <c:forEach var="prova" items="${dao.provas }">
                    <tr>
                        <td><c:out value="${prova.disciplina }"></c:out></td>
                        <td><c:out value="${prova.id }"></c:out></td>
                        <td><c:out value="${prova.qtdQuestoes }"></c:out></td>
                        <td width="20px"><a href="paginas/mostra-prova.jsp?prova=<c:out value='${prova.id }'></c:out>" 
                        class="btn btn-primary" data-toggle="tooltip" data-placement="left" title="Visualizar prova">
                        <span class="glyphicon glyphicon-eye-open"></span></a></td>
                        <td width="20px"> 
	                        <form action="/aplicarProv/excluir" method="post" class="form-excluir">
	                        	<input type="hidden" value="${prova.id }" name="prova">    
	                        	<button type="submit" class="btn btn-danger excluir" data-toggle="tooltip" data-placement="left" title="Remover">
								<span class="glyphicon glyphicon-trash"></span></button>
	                        </form>
                        </td>
                        <td width="20px">
                        	<a href="paginas/prova.jsp?prova=<c:out value='${prova.id }'/>" class="btn btn-success"
                        	data-toggle="tooltip" data-placement="left" title="Fazer prova"><span class="glyphicon glyphicon-pencil"></span></a>
                        </td>
                    </tr>
                </c:forEach>
                    
                </tbody>
	       </table>
        </div>
	</body>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="resources/js/index.js"></script>
</html>
