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
        <h1>Geolocali Farmacia</h1>
        <!--
            <form action="medicineSearch" method="get">
                <input type="submit" value="Buscar medicinas">
            </form>
            <form action="PharmacySearch">
                <input type="submit" value="Buscar farmacias">
            </form>
        -->
        <h3>Buscar farmacias</h3>
        <form action="">
            <input type="submit" value="Buscar farmacia mas cercana">
        </form>
        <form action="searchByName">
            <input type="submit" value="Buscar farmacia por nombre">
        </form>
        <form action="searchByMedicine">
            <input type="submit" value="Buscar farmacia por medicina">
        </form>
        <form action="searchByService">
            <input type="submit" value="Buscar farmacia por servicio">
        </form>
        <h3>Menu de administracion</h3>
        <form action="inicioSesion">
            <input type="submit" value="Iniciar sesion de administracion">
        </form>
    </body>
</html>
