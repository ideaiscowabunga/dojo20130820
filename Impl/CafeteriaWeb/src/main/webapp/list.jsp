<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<table border="1" cellpadding="1" cellspacing="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Descrição</th>
				<th>Valor</th>
				<th>Ação</th>
			</tr>

		</thead>
		<tbody>
			<c:forEach items="${cafes}" var="cafe">
				<tr class="cafe" id="cafe${cafe.id}">
					<td>${cafe.id}</td>
					<td>${cafe.nome}</td>
					<td>${cafe.descricao}</td>
					<td>R$ ${cafe.preco}</td>
					<td><a href="delete?id=${cafe.id}" id="delete${cafe.id}">Excluir</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<form action="create" method="post">
				<tr id="novoCafe" id="cafe">
					<td>+</td>
					<td><input type="text" name="nome" placeholder="Nome" id="nomeCafe"></td>
					<td><input type="text" name="descricao" placeholder="Descrição" id="descricaoCafe"></td>
					<td>R$ <input type="text" name="preco" placeholder="Preço" id="precoCafe"></td>
					<td><input type="submit" name="Criar" value="Criar" id="btCriar"></td>
				</tr>
			</form>
		</tfoot>
	</table>
</body>
</html>