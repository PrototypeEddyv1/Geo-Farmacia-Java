<%-- 
    Document   : inicioSesion
    Created on : Jun 22, 2024, 6:48:28 PM
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
        <form action="/index.jsp">
            <input type="submit" value="regresar">
        </form>
        <form action="ProcessLogin" method="get">
            <h1>Inicio de sesion</h1>
            <h2>Solo los administradores pueden iniciar sesion</h2>
            <table>
                <tr>
                    <td>Usuario</td>
                    <td><input name="username" placeholder="Usuario"></td>
                </tr>
                <tr>
                    <td>Contraseña</td>
                    <td><input name="password" placeholder="Constraseña"></td>
                </tr>
            </table>
            <input type="submit" value="Iniciar sesion">
        </form>
    </body>
</html>
