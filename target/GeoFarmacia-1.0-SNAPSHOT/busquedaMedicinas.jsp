<%-- 
    Document   : busquedaFarmacias
    Created on : Jun 22, 2024, 4:06:57 PM
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
        <h1>Busqueda Medicinas</h1>
        <form action="/index.jsp">
            <input type="submit" value="regresar">
        </form>
        <form action="directToMap">
            <input id="inputMedicineSelected" type="hidden" name="selectedMedicineList">
            <div class="selectorDiv">
                <!--Medicinas seleccionadas-->
                <div class="listScreen">
                    <h3>Medicinas seleccionadas</h3>
                    <input class="searchInput" type="text" id="selectedMedicineText" placeholder="Medicina busqueda">
                    <div class="listSelector" id="selectedMedicine">
                        <!--
                        <div class="wrap-flex listItem">
                            <input class="wrap-flex" type="checkbox" id="vehicle1" name="vehicle1" value="Bike">
                            <label class="wrap-flex" for="vehicle1"> I have a bike</label><br>
                        </div>-->
                    </div>
                </div>
                <!--Medicinas por seleccionar-->
                <div class="listScreen">
                    <h3>Medicinas sin seleccionadas</h3>
                    <input class="searchInput" type="text" id="unselectedMedicineText" placeholder="Medicina busqueda">
                    <div class="listSelector" id="unselectedMedicine">
                        <!--
                        <div class="wrap-flex listItem">
                            <input class="wrap-flex" type="checkbox" id="vehicle1" name="vehicle1" value="Bike">
                            <label class="wrap-flex" for="vehicle1"> I have a bike</label><br>
                        </div>-->
                    </div>
                </div>
            </div>
            <h2>Especificacion de farmacia</h2>
            <table>
                <tr>
                    <td><p>Horario de apertura</p></td>
                    <td><p>Horario de clausura</p></td>
                </tr>
                <tr>
                    <td><input type="time" placeholder="Apertura" name="open_time"></td>
                    <td><input type="time" placeholder="Cerradura" name="close_time"></td>
                </tr>
            </table>
            <table>
                <tr>
                    <td><p>Nombre de la farmacia</p></td>
                    <td colspan="3"><input class="searchInput" placeholder="Nombre de farmacia" name="pharmacy_name"></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td><p>Intervalo de costo:</p></td>
                    <td><input type="number" placeholder="Minimo" name="maxCost"></td>
                    <td><p>a</p></td>
                    <td><input type="number" placeholder="Maximo" name="minCost"></td>
                </tr>
            </table>
            <input type="button" value="PROBAR" onclick="checkResults()">
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
        //Add the unselectedList of selected
        for (var i = 0; i < unselectedList.length; i++){
            var inp
            setClassId = i+"unselected"
            //Create div
            di = document.createElement('div');
            di.setAttribute("class","wrap-flex listItem")
            di.setAttribute("id",setClassId+"Item");
            //Create input checkbox
            inp = document.createElement('input')
            inp.type="checkbox"
            inp.setAttribute("id",setClassId)
            inp.addEventListener("change", changeSelectLists);
            //console.log(i)
            //Create label
            lab = document.createElement('label');
            lab.innerHTML = unselectedList[i]
            lab.setAttribute("for",setClassId)
            lab.setAttribute("class",setClassId+"Label")
            //Append thing
            di.append(inp)
            di.append(lab)
            document.getElementById("unselectedMedicine").append(di)
        }
        //Add to the selected
        function changeSelectLists(event){
            
            //console.log(event.target.id)
            idString = event.target.id
            idNum = ""
            for(i = 0; i < idString.length; i++){
                const char = idString.charAt(i);
                if (char >= '0' && char <= '9'){
                    idNum += char
                }
            }
            if (event.target.checked == true){
                setClassId = idNum+"selected"
                //Create div
                di = document.createElement('div');
                di.setAttribute("class","wrap-flex listItem")
                di.setAttribute("id",setClassId+"Item");
                //Create input checkbox
                inp = document.createElement('input')
                inp.type="checkbox"
                inp.setAttribute("id",setClassId)
                inp.addEventListener("click", changeSelectLists);
                inp.setAttribute("checked",true)
                
                //Create label
                lab = document.createElement('label');
                lab.innerHTML = unselectedList[idNum]
                lab.setAttribute("for",setClassId)
                lab.setAttribute("class",setClassId+"Label")
                //Append thing
                di.append(inp)
                di.append(lab)
                document.getElementById("selectedMedicine").append(di)
            }else{
                console.log(idNum+"selectedItem")
                document.getElementById(idNum+"unselected").checked = false
                const deleteDiv = document.getElementById(idNum+"selectedItem").remove()
            }
            changingResults()
        }
        function changingResults(){
            //document.getElementById("selectedMedicine").children[0].children[0].id
            var idSelected = []
            for (i = 0; i < document.getElementById("selectedMedicine").children.length; i++){
                idNum = ""
                for(j = 0; j < idString.length; j++){
                    const char = document.getElementById("selectedMedicine").children[i].children[0].id.charAt(j);
                    if (char >= '0' && char <= '9'){
                        idNum += char
                    }
                }
                idSelected.push(idNum)
            }
            document.getElementById("inputMedicineSelected").value = idSelected
            console.log(idSelected);
        }
    </script>
</html>