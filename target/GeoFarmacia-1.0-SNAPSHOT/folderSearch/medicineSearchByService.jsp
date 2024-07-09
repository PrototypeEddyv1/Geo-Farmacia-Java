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
            <label for="serviceNameInput">Nombre del servicio</label>
            <br>
            <input id="serviceNameInput" type="text" name="serviceName">
            <label for="comboBox">Choose an option:</label>
            <select id="comboBox" name="comboBox">
                <option value="option1">Farmacia</option>
                <option value="option2">Panaderia</option>
                <option value="option3">Abarrotes</option>
                <option value="option4">Fotografias</option>
                <option value="option5">Carnes frias</option>
                <option value="option6">Bebidas</option>
                <option value="option7">Consultorio medico</option>
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
