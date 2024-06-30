<%-- 
    Document   : mainAdminMenu
    Created on : Jun 24, 2024, 11:54:19 AM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="adminTag" uri="/WEB-INF/tlds/customTags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <adminTag:UserNav></adminTag:UserNav>
        <h1>MENU DE ADMINISTRACION</h1>
        <form action="farmacias" method="get">
            <input type="submit" value="Administrar farmacias">
        </form>
        <form action="servicios">
            <input type="submit" value="Administrar servicios">
        </form>
        <form action="productos">
            <input type="submit" value="Administrar productos">
        </form>
        <form action="tipoProductos">
            <input type="submit" value="Administrar tipos">
        </form>
        <form action="usuarios">
            <input type="submit" value="Administrar usuarios">
        </form>
        <form action="roles">
            <input type="submit" value="Administrar roles">
        </form>
        <form action="modulos">
            <input type="submit" value="Administrar modulos">
        </form>
    </body>
</html>
