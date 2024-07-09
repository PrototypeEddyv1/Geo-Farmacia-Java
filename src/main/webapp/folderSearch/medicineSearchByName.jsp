<%-- 
    Document   : medicineSearchByName
    Created on : Jul 2, 2024, 12:09:15 AM
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
        <h1>Busqueda de farmacia por nombre</h1>
        <form >
            <input type="submit" value="Regresar">
        </form>
        <form action="searchMap">
            <label for="pharmacyNameInput">Nombre del a farmacia</label>
            <br>
            <input id="pharmacyNameInput" type="text" name="pharmacyName">
            <input type="submit" value="Buscar">
        </form>
    </body>
</html>
