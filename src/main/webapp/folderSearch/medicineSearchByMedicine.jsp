<%-- 
    Document   : medicineSearchByMedicine
    Created on : Jul 2, 2024, 12:28:05 AM
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
        <form action="">
            <input type="submit" value="Regresar">
        </form>
        <form action="searchMap">
            <label for="pharmacyMedicineInput">Nombre de la medicina</label>
            <br>
            <input id="pharmacyMedicineInput" type="text" name="pharmacyMedicine">
            <input type="submit" value="Buscar">
        </form>
    </body>
</html>
