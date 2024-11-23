<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>iniciar sesion</title>
<link rel="stylesheet" type="text/css" href="/styles2.css">
</head>
<body>
	<header>
		<h1>Artículos</h1>
		<ul>
			<li><a href="/">Login</a></li>
			<li><a href="/registro">Registro</a></li>
		</ul>
	</header>
	<h2>Iniciar Sesión</h2>
	<form:form action="/login" method="POST" modelAttribute="loginUsuario">

		<form:label path="correo">Email:</form:label>
		<form:input path="correo" type="text" />
		<form:errors path="correo" />
		
		<form:label path="password">Contraseña:</form:label>
		<form:input path="password" type="password" />
		<form:errors path="password" />
		
		<input type="submit" value="Iniciar Sesión" />
	</form:form>
</body>
</html>