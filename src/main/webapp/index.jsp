<%-- 
    Document   : index
    Created on : Jun 16, 2024, 8:05:37 PM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hola mundo, aqui Eduardo</h1>
        <form action="conexionMysql" method="post">
            <label>Nombre: </label>
            <input name="nombre">
            <label>Apellido: </label>
            <input name="apellido">
            <input type="submit">
        </form>
        <form action="conexionMysql" method="get">
            <input type="submit">
        </form>
    </body>
</html>
