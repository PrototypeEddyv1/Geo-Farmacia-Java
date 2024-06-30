<%-- 
    Document   : productsForm
    Created on : Jun 25, 2024, 2:16:54 PM
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
        <h1>INFO PRODUCTO</h1>
        <form>
            <table>
                <tr>
                    <td>Nombre del producto</td>
                    <td><input name="productName"></td>
                </tr>
                <tr>
                    <td>Tipo de producto</td>
                    <td><input name="productType"></td>
                </tr>
                <tr>
                    <td>Cantidad (Medida)</td>
                    <td><input name="productQuantity"></td>
                </tr>
                <tr>
                    <td>Unidad de medida</td>
                    <td><input name="productMeasurement"></td>
                </tr>
                <tr>
                    <td>Proovedor</td>
                    <td><input name="productProvider"></td>
                </tr>
                <tr>
                    <td>Para menores</td>
                    <td><input type="checkbox" name="productKids"></td>
                </tr>
            </table>
            <input type="submit" value="Crear medicina">
        </form>
        <form>
            <input type="submit" value="Eliminar">
        </form>
    </body>
</html>
