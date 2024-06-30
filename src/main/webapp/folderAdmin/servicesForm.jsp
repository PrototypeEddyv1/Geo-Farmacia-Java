<%-- 
    Document   : servicesForm
    Created on : Jun 25, 2024, 2:35:57 PM
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
        <h1>INFO SERVICIO</h1>
        <form>
            <table>
                <tr>
                    <td>Nombre del servicio</td>
                    <td><input name="serviceName"></td>
                </tr>
                <tr>
                    <td>Horario de apertura</td>
                    <td><input name="serviceOpen"></td>
                </tr>
                <tr>
                    <td>Horario de cierre</td>
                    <td><input name="serviceClose"></td>
                </tr>
            </table>
            <input type="submit" value="Crear Servicio">
        </form>
        <form>
            <input type="submit" value="Eliminar">
        </form>
    </body>
</html>