<%-- 
    Document   : pharmacyTableResults
    Created on : Jul 4, 2024, 11:06:59 AM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.google.gson.JsonArray;"%>
<!DOCTYPE html>
<html>
    <%
         JsonArray pharmaciesList = (JsonArray) request.getAttribute("pharmaciesList");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Resultados</h1>
        <table id="pharmacyTable">
            <tr>
                <th>Nombre de farmacia</th>
                <th>Direccion</th>
                <th>Telefono</th>
                <th>¿Acepta tarjeta?</th>
                <th>Desplegar</th>
            </tr>
            <tr>
                <td>Farmacia 1</td>
                <td>Calle con un nombre, luego un numero de casa si es necesario</td>
                <td>123456789</td>
                <td>No</td>
                <td>
                    <form>
                        <input type="submit" value="Ver en mapa">
                        <input type="hidden" name="position">
                    </form>
                </td>
            </tr>
        </table>
    </body>
    <style>
        table {
            margin:auto;
            width: 90%;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #f1f1f1;
        }
    </style>
    <script>
        // Datos de ejemplo en formato JSON
        /*
        const pharmaciesJson = `[
            {
                "id_pharmacy":1,
                "name":"Farmacia A",
                "status":"Activa",
                "direction":"Calle Principal 123",
                "latitude":19.4326,
                "longitude":-99.1332,
                "phoneNumber":"123456789",
                "accepts_card":true
        }]`*/
        console.log("Attribute: ",<%=pharmaciesList.toString()%>);
        //console.log("Attribute 2: ",pharmaciesJson);
        const pharmacies = <%=pharmaciesList.toString()%>/*JSON.parse(pharmaciesJson)*/;
        console.log(pharmacies)
        // Función para calcular la distancia entre dos puntos usando la fórmula de Haversine
        function haversineDistance(lat1, lon1, lat2, lon2) {
            const toRad = (x) => (x * Math.PI) / 180;
            const R = 6371; // Radio de la Tierra en km
            const dLat = toRad(lat2 - lat1);
            const dLon = toRad(lon2 - lon1);
            const a =
                Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(toRad(lat1)) * Math.cos(toRad(lat2)) *
                Math.sin(dLon / 2) * Math.sin(dLon / 2);
            const c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            return R * c;
        }

        // Función para llenar la tabla con datos ordenados
        function populateTable(sortedPharmacies) {
            const table = document.getElementById("pharmacyTable");
            sortedPharmacies.forEach(pharmacy => {
                const row = table.insertRow();
                const nameCell = row.insertCell(0);
                const addressCell = row.insertCell(1);
                const phoneCell = row.insertCell(2);
                const cardCell = row.insertCell(3);
                const actionCell = row.insertCell(4);

                nameCell.textContent = pharmacy.name;
                addressCell.textContent = pharmacy.direction;
                phoneCell.textContent = pharmacy.phoneNumber;
                cardCell.textContent = pharmacy.acceptsCreditCard ? "Sí" : "No";

                const form = document.createElement("form");
                form.setAttribute("action","mapa");
                const submitInput = document.createElement("input");
                submitInput.type = "submit";
                submitInput.value = "Ver en mapa";
                const hiddenInput = document.createElement("input");
                hiddenInput.type = "hidden";
                hiddenInput.name = "position";
                hiddenInput.value = pharmacy.latitude + ","+pharmacy.longitude;
                form.appendChild(submitInput);
                form.appendChild(hiddenInput);
                actionCell.appendChild(form);
            });
        }

        // Función para obtener la geolocalización y ordenar las farmacias
        function sortPharmaciesByDistance() {
            if (navigator.geolocation) {
                navigator.geolocation.getCurrentPosition(position => {
                    const userLat = position.coords.latitude;
                    const userLon = position.coords.longitude;

                    pharmacies.forEach(pharmacy => {
                        pharmacy.distance = haversineDistance(userLat, userLon, pharmacy.latitude, pharmacy.longitude);
                    });

                    const sortedPharmacies = pharmacies.sort((a, b) => a.distance - b.distance);
                    populateTable(sortedPharmacies);
                }, error => {
                    console.error("Error obteniendo la geolocalización: ", error);
                    populateTable(pharmacies); // En caso de error, mostrar sin ordenar
                });
            } else {
                console.error("Geolocalización no soportada por el navegador");
                populateTable(pharmacies); // Si geolocalización no es soportada, mostrar sin ordenar
            }
        }

        // Ordenar y llenar la tabla cuando se carga la página
        document.addEventListener("DOMContentLoaded", sortPharmaciesByDistance);
    </script>
</html>
