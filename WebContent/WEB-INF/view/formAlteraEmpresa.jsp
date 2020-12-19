<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada?acao=EditaEmpresa" var="linkservletAlteraEmpresa"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

	<c:import url="logout-parcial.jsp" />



<form action="${linkservletAlteraEmpresa}" method="post">
	
		Nome:  <input type="text" name="nome" value="${empresa.nome }" />
		Data de Abertura:  <input type="text" name="date" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>" />
			   <input type="hidden" name="id" value="${empresa.id}"/>	
			   <input type="submit"/>	
		 

</form>

</body>
</html>