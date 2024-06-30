<%-- 
    Document   : medicineTable
    Created on : Jun 24, 2024, 3:53:10 PM
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
        <adminTag:UserNav/>
        <form>
            <input type="hidden" name="method" value="create">
            <input type="submit" value="Agregar nuevo usuario">
        </form>
        <table>
            <adminTag:searchInputField>nombre</adminTag:searchInputField>
            <adminTag:searchInputField>farmacia</adminTag:searchInputField>
        </table>
        <table>
            <tr>
                <th>Nombre de Usuario</th>
                <th>Rol</th>
                <th>Configuracion</th>
            </tr>
            <tr>
                <td>Nombre de usuario</td>
                <th>Rol</th>
                <td>
                    <form action="usuarios">
                        <input type="hidden" name="id" value="">
                        <input type="submit" value="Editar">
                    </form>
                </td>
            </tr>
            <tr>
                <td>Nombre de usuario</td>
                <th>Rol</th>
                <td>
                    <form action="usuarios">
                        <input type="hidden" name="id" value="">
                        <input type="submit" value="Editar">
                    </form>
                </td>
            </tr>
        </table>
    </body>
</html>
