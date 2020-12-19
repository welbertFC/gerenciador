<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.List,br.com.curso.gerenciador.modelo.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Empresas Cadastradas: </title>
</head>
<body>
	
	<c:import url="logout-parcial.jsp" />

	
	Usuario Logado: ${usuarioLogado.login}
	
	<br>
	<br>
	
		
		<c:if test="${not empty empresa }">
		
		Nenhuma empresa cadastrada 
		
		</c:if>
	
	Lista de empresa: <br/>
	
	<ul>
		<c:forEach items="${empresas}" var="empresa">
			<li>${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
			<a href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id}">edita</a>
			<a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id}">remove</a></li>
			
		</c:forEach>	
	</ul>	
		
</body>
</html>