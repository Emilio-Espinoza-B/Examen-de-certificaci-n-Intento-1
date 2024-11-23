<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalle del Artículo</title>
    <link rel="stylesheet" type="text/css" href="/styles.css">
</head>
<body>
    <div class="container">
        <header>
            <h1>Artículos</h1>
            <nav>
                <ul>
                    <li><a href="/articulos">Todos los Artículos</a></li>
                    <li><a href="/form/agregar">Agregar Artículo</a></li>
                    <li><a href="/logout">Logout</a></li>
                </ul>
            </nav>
        </header>

        <section class="articulo-detail">
            <h2>Detalle del Artículo</h2>
            <ul>
                <li><strong>Articulo creado por:</strong> ${articulo.creador.nombre} ${articulo.creador.apellido}</li>
                <li><strong>Categoría/Tema:</strong> ${articulo.categoria}</li>
                <li><strong>Descripción:</strong> ${articulo.descripcion}</li>
            </ul>

            <form:form action="/eliminar/${articulo.id}" method="POST">
                <input type="hidden" name="_method" value="DELETE"/>
                <button class="delete-button">Eliminar Artículo</button>
            </form:form>
        </section>
    </div>
</body>
</html>
