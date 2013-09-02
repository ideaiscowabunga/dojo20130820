<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<table>
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
					<td>${cafe.preco}</td>
					<td><a href="/delete?id=${cafe.id}" id="delete${cafe.id}"></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			
		</tfoot>
	</table>
</body>
</html>