<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>articulos</title>
<link rel="stylesheet" type="text/css" href="/styles1.css">
</head>
<body>
	<header>
	<h1>Artículos</h1>
	<ul>
		<li><a href="/articulos">Todos los Articulos</a></li>
		<li><a href="/form/agregar">Agregar Articulos</a></li>
		<li><a href="/logout">Logout</a></li>
	</ul>
	</header>
	<h2>Bienvenido de vuelta ${nombreCompleto}</h2>
	<table border="1">
	<thead>
		<th>Titulo</th>
		<th>Detalle</th>
		<th>Modificar</th>
		<th>Me Gusta</th>
	</thead>
	<tbody>
		<c:forEach var="articulo" items="${articulos}">
			<tr>
				<td>${articulo.titulo}</td>
				<td><a href="/detalle/${articulo.id}">Ver</a></td>
				<td>
					<c:if test="${articulo.creador.id == idUsuario}">
						<a href="/form/editar/${articulo.id}">Editar</a>
					</c:if>
				</td>
				<td>
			    <c:if test="${favsUsuario != null}">
			        <c:choose>
			            <c:when test="${favsUsuario.contains(articulo)}">
			                <form:form action="/quitarFav/${articulo.id}" method="POST">
			                    <input type="hidden" name="_method" value="DELETE"/>
			                    <button style="font-size: 27px">&#9829;</button>
			                </form:form>
			            </c:when>
			            <c:otherwise>
			                <form:form action="/agregarFav/${articulo.id}" method="POST">
			                    <button style="font-size: 27px">&#9825;</button>
			                </form:form>
			            </c:otherwise>
			        </c:choose>
			    </c:if>
			</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
</body>
</html>