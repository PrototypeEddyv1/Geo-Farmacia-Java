<%-- 
    Document   : rolesForm
    Created on : Jun 25, 2024, 2:21:56 PM
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
        <h1>INFO ROL</h1>
        <form>
            <table>
                <tr>
                    <td>Nombre del rol</td>
                    <td><input name="roleName"></td>
                </tr>
                <tr>
                    <td>Modulo</td>
                    <td><input name="rolemodule"></td>
                </tr>
            </table>
            <h2>PERMISOS</h2>
            <table>
                <tr>
                    <th>Puede</th>
                    <th>Crear</th>
                    <th>Leer</th>
                    <th>Editar</th>
                    <th>Eliminar</th>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="checkbox" name="canCreate"></td>
                    <td><input type="checkbox" name="canRead"></td>
                    <td><input type="checkbox" name="canEdit"></td>
                    <td><input type="checkbox" name="canDelete"></td>
                </tr>
            </table>
            <input type="submit" value="Crear Rol">
        </form>
        <form>
            <input type="submit" value="Eliminar">
        </form>
    </body>
</html>
