<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Agregar Artículo</title>
    <link rel="stylesheet" type="text/css" href="/styles3.css">
</head>
<body>
    <header>
        <h1>Artículos</h1>
        <nav>
            <ul>
                <li><a href="/articulos">Todos los Artículos</a></li>
                <li><a href="/form/agregar">Agregar Artículos</a></li>
                <li><a href="/logout">Logout</a></li>
            </ul>
        </nav>
    </header>

    <div class="form-container">
        <h2>Agregar Artículo</h2>

        <form:form action="/guardar" method="POST" modelAttribute="articulo">
            <div class="form-group">
                <form:label path="titulo">Título:</form:label>
                <form:input path="titulo" type="text" class="form-input" />
                <form:errors path="titulo" cssClass="form-error"/>
            </div>

            <div class="form-group">
                <form:label path="descripcion">Descripción:</form:label>
                <form:textarea path="descripcion" rows="5" class="form-input"></form:textarea>
                <form:errors path="descripcion" cssClass="form-error"/>
            </div>
            
            <div class="form-group">
                <form:label path="categoria">Categoría/Tema:</form:label>
                <form:input path="categoria" type="text" class="form-input" />
                <form:errors path="categoria" cssClass="form-error"/>
            </div>

            <input type="hidden" value="${idUsuario}" name="creador" />
            <input type="submit" value="Agregar Artículo" class="submit-button" />
        </form:form>
    </div>

</body>
</html>
