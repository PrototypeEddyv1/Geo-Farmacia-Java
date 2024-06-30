<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="/index.jsp">
            <input type="submit" value="regresar">
        </form>
        <h1>Especificacion de Farmacia</h1>
        <form action="directToMap">
            <table>
                <tr>
                    <td><p>Nombre de la farmacia</p></td>
                    <td colspan="3"><input class="searchInput" placeholder="Nombre de farmacia"></td>
                </tr>
                <tr>
                    <td><p>Horario de apertura</p></td>
                    <td><p>Horario de clausura</p></td>
                </tr>
                <tr>
                    <td><input type="time" placeholder="Apertura"></td>
                    <td><input type="time" placeholder="Apertura"></td>
                </tr>
            </table>
            <h2>Servicios</h2>
            <table>
                <tr>
                    <td><p>Nombre de la farmacia</p></td>
                    <td colspan="4"><input class="searchInput" placeholder="Nombre de farmacia"></td>
                </tr>
                <tr>
                    <td><p>Horario de apertura</p></td>
                    <td><p>Horario de clausura</p></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td><input type="time" class="searchInput" placeholder="Apertura"></td>
                    <td><input type="time" class="searchInput" placeholder="Apertura"></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td><p>Intervalo de costo:</p></td>
                    <td><input type="number" placeholder="Minimo"></td>
                    <td><p>a</p></td>
                    <td><input type="number" placeholder="Maximo"></td>
                </tr>
            </table>
            <h2>Busqueda medicinas</h2>
            <div class="selectorDiv">
                <!--Medicinas seleccionadas-->
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
                <!--Medicinas por seleccionar-->
                <div class="listScreen">
                    <h3>Medicinas seleccionadas</h3>
                    <input class="searchInput" type="text" id="unselectedMedicineText" placeholder="Medicina busqueda">
                    <div class="listSelector" id="unselectedMedicine">
                        <div class="wrap-flex listItem">
                            <input class="wrap-flex" type="checkbox" id="vehicle1" name="vehicle1" value="Bike">
                            <label class="wrap-flex" for="vehicle1"> I have a bike</label><br>
                        </div>
                    </div>
                </div>
            </div>
            <h2>Busqueda productos</h2>
            <div class="selectorDiv">
                <!--Medicinas seleccionadas-->
                <div class="listScreen">
                    <h3>Medicinas seleccionadas</h3>
                    <input class="searchInput" type="text" id="selectedProductsText" placeholder="Medicina busqueda">
                    <div class="listSelector" id="selectedProducts">
                        <div class="wrap-flex listItem">
                            <input class="wrap-flex" type="checkbox" id="vehicle1" name="vehicle1" value="Bike">
                            <label class="wrap-flex" for="vehicle1"> I have a bike</label><br>
                        </div>
                    </div>
                </div>
                <!--Medicinas por seleccionar-->
                <div class="listScreen">
                    <h3>Medicinas seleccionadas</h3>
                    <input class="searchInput" type="text" id="unselectedProductsText" placeholder="Medicina busqueda">
                    <div class="listSelector" id="unselectedProducts">
                        <div class="wrap-flex listItem">
                            <input class="wrap-flex" type="checkbox" id="vehicle1" name="vehicle1" value="Bike">
                            <label class="wrap-flex" for="vehicle1"> I have a bike</label><br>
                        </div>
                    </div>
                </div>
            </div>
            <input type="submit" value="Buscar">
        </form>
    </body>
    <style>
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
            margin:0px auto 0px auto;
            flex-wrap: wrap;
            width:35%;
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
    <script>
        var unselectedList = [
            "Nombre1",
            "Nombre2",
            "Nombre3",
            "Nombre4",
            "Nombre5",
            "Nombre6",
            "Nombre7",
            "Nombre8",
            "Nombre9",
            "Nombre10",
            "Nombre11"
        ]
        //Add the unselectedList of unselected producs
        for (var i = 0; i < unselectedList.length; i++){
            setClassId = i+"unselected"
            //Create div
            di = document.createElement('div');
            di.setAttribute("class","wrap-flex listItem")
            di.setAttribute("id",setClassId+"Item");
            //Create input checkbox
            inp = document.createElement('input')
            inp.type="checkbox"
            inp.setAttribute("id",setClassId)
            //Create label
            lab = document.createElement('label');
            lab.innerHTML = "HOLA"
            lab.setAttribute("for",setClassId)
            lab.setAttribute("class",setClassId+"Label")
            //Append thing
            di.append(inp)
            di.append(lab)
            document.getElementById("unselectedMedicine").append(di)
            console.log("ITEM");
        }
        //Add the unselectedList of unselected products
        for (var i = 0; i < unselectedList.length; i++){
            setClassId = i+"unselected"
            //Create div
            di = document.createElement('div');
            di.setAttribute("class","wrap-flex listItem")
            di.setAttribute("id",setClassId+"Item");
            //Create input checkbox
            inp = document.createElement('input')
            inp.type="checkbox"
            inp.setAttribute("id",setClassId)
            //Create label
            lab = document.createElement('label');
            lab.innerHTML = "HOLA"
            lab.setAttribute("for",setClassId)
            lab.setAttribute("class",setClassId+"Label")
            //Append thing
            di.append(inp)
            di.append(lab)
            document.getElementById("unselectedProducts").append(di)
            console.log("ITEM");
        }
    </script>
</html>
