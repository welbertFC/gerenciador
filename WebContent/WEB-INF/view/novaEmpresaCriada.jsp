<%

//scriplet
//String nomeEmpresa = (String)request.getAttribute("empresa");
//=//nomeEmpresa  /*out.println(nomeEmpresa);*/  


%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Novas empresas registradas</title>
</head>
	<body>
		
		<c:if test="${not empty empresa }">
		
		Empresa ${ empresa } criada: <fmt:formatDate value="${dataempresa}" pattern="dd/MM/yyyy"/>   cadastrada com sucesso!
		
		</c:if>
		
		<c:if test="${empty empresa }">
		
		Nenhuma empresa cadastrada 
		
		</c:if>
	
	
		

	</body>
</html>