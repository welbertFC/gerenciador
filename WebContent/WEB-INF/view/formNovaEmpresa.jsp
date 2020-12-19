<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada?acao=NovaEmpresa" var="linkservletNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:import url="logout-parcial.jsp" />



<form action="${linkservletNovaEmpresa }" method="post">
	
		Nome:  <input type="text" name="nome" />
		Data de Abertura:  <input type="text" name="date" />
		
			   <input type="submit"/>	
		 

</form>

</body>
</html>