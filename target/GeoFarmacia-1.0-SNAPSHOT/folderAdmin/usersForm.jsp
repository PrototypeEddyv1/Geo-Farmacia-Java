<%-- 
    Document   : usersForm
    Created on : Jun 25, 2024, 2:38:31 PM
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
        <h1>INFO USUARIO</h1>
        <form>
            <table>
                <tr>
                    <td>Nombre de usuario</td>
                    <td><input name="userName"></td>
                </tr>
                <tr>
                    <td>Contraseña</td>
                    <td><input name="userPassword"></td>
                </tr>
                <tr>
                    <td>Roles</td>
                    <td>
                        <div class="listScreen">
                            <h3>Medicinas seleccionadas</h3>
                            <input class="searchInput" type="text" id="selectedMedicineText" placeholder="Medicina busqueda">
                            <div class="listSelector" id="selectedMedicine">
                                <div class="wrap-flex listItem">
                                    <input class="wrap-flex" type="checkbox" id="vehicle1" name="vehicle1" value="Bike">
                                    <label class="wrap-flex" for="vehicle1"> I have a bike</label><br>
                                </div>
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>Farmacia</td>
                    <td><input type="select" name="userPharmacy"></td>
                </tr>
            </table>
            <input type="submit" value="Crear Usuario">
        </form>
        <form>
            <input type="submit" value="Eliminar">
        </form>
    </body>
    <style>
        table{
            width:50%;
        }
        .wrap-flex{
            display: flex;
            flex-wrap: wrap;
        }
        /*Lists*/
        .selectorDiv{
            margin:0px auto 0px auto;
            width:100%;
            display: flex;
            flex-wrap: wrap;
        }
        .listScreen{
            margin:0px 0px 0px 0px;
            flex-wrap: wrap;
            width:90%;
            height:300px;
            overflow:hidden;
            background:rgb(176, 176, 176);
        }
        .listScreen .searchInput{
            width:100%;
        }
        .searchInput{
            width:100%;
        }
        .listSelector{
            margin: 5% 20px 0px 20px;
            height:60%;
            overflow-y:scroll;
        }
        .listItem{
            margin: 0px 0px 10px 0px;
        }
    </style>
</html>