<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada?acao=Login" var="linkservletNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<form action="${linkservletNovaEmpresa }" method="post">
	
		Login:  <input type="text" name="login" />
		Senha:  <input type="password" name="senha" />
		
			   <input type="submit"/>	
		 

</form>

</body>
</html>