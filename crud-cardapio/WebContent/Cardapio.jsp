<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@page import="model.Cardapio" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cardapio</title>
</head>
<body>
	<%Cardapio cardapio = (Cardapio)request.getAttribute("cardapio"); %> 
	Id Produto:<%=cardapio.getIdProduto() %><br> 
	Nome do Prato: <%=cardapio.getNomeProduto() %><br> 
	Descrição: <%=cardapio.getDescProduto() %><br> 
	Valor: <%=cardapio.getValorProduto() %><br> 
	Disponibilidade: <%=cardapio.getDispProduto() %><br>
	<a href="cardapio.html">Voltar</a>
</body>
</html>