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
        <h1>Busqueda de farmacia por nombre de servicio</h1>
        <form>
            <input type="submit" value="Regresar">
        </form>
        <form action="searchMap">
            <!--
            <label for="serviceNameInput">Nombre del servicio</label>
            <br>
            <input id="serviceNameInput" type="text" >
            -->
            <label for="comboBox">Nombre del servicio:</label>
            <select id="comboBox" name="serviceName">
                <option value="Farmacia">Farmacia</option>
                <option value="Panaderia">Panaderia</option>
                <option value="Fotografias">Fotografias</option>
                <option value="Abarrotes">Abarrotes</option>
                <option value="Medico">Medico</option>
                <option value="vinos y licores">vinos y licores</option>
            </select>
            <script>
                // JavaScript to handle the change event
                document.getElementById("comboBox").addEventListener("change", function() {
                    const selectedOption = this.value;
                    console.log("Selected:", selectedOption);
                });
            </script>
            <input type="submit" value="Buscar">
        </form>
    </body>
</html>
