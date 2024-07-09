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
            <input id="inputMedicineSelected" type="hidden" name="selectedMedicineList">
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
                    </div>
                </div>
                <!--Medicinas por seleccionar-->
                <div class="listScreen">
                    <h3>Medicinas seleccionadas</h3>
                    <input class="searchInput" type="text" id="unselectedMedicineText" placeholder="Medicina busqueda">
                    <div class="listSelector" id="unselectedMedicine">
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
                    </div>
                </div>
                <!--Medicinas por seleccionar-->
                <div class="listScreen">
                    <h3>Medicinas seleccionadas</h3>
                    <input class="searchInput" type="text" id="unselectedProductsText" placeholder="Medicina busqueda">
                    <div class="listSelector" id="unselectedProducts">
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
        var avaliableMedicineList = JSON.parse('<%= request.getAttribute("MedicineList") %>');
        var avaliableProductList = JSON.parse('<%= request.getAttribute("ProductList") %>');
        
        var unselectedMedicineList
        var unselectedMedicineListIds
        var unselectedProductList
        var unselectedProductListIds
        
        unselectedMedicineList = new Array(Object.keys(avaliableMedicineList).length)
        unselectedMedicineListIds = new Array(Object.keys(avaliableMedicineList).length)
        unselectedProductList = new Array(Object.keys(avaliableProductList).length)
        unselectedProductListIds = new Array(Object.keys(avaliableProductList).length)
        
        for (var key in avaliableMedicineList) {
            if (avaliableMedicineList.hasOwnProperty(key)) {
                unselectedMedicineList[key] = avaliableMedicineList[key].name
                unselectedMedicineListIds[key] = avaliableMedicineList[key].id_product
            }
        }
        for (var key in avaliableProductList) {
            if (avaliableProductList.hasOwnProperty(key)) {
                unselectedProductList[key] = avaliableProductList[key].name
                unselectedProductListIds[key] = avaliableProductList[key].id_product
            }
        }
    
        //Add the unselectedList of unselected producs
        for (var i = 0; i < unselectedMedicineList.length; i++){
            setClassId = unselectedMedicineListIds[i]+"unselected"
            //Create div
            di = document.createElement('div');
            di.setAttribute("class","wrap-flex listItem")
            di.setAttribute("id",setClassId+"Item");
            //Create input checkbox
            inp = document.createElement('input')
            inp.type="checkbox"
            inp.setAttribute("id",setClassId)
            inp.addEventListener("change", changeSelectMedicineLists);
            //Create label
            lab = document.createElement('label');
            lab.innerHTML = unselectedMedicineList[i]
            lab.setAttribute("for",setClassId)
            lab.setAttribute("class",setClassId+"Label")
            //Append thing
            di.append(inp)
            di.append(lab)
            document.getElementById("unselectedMedicine").append(di)
            console.log("ITEM");
        }
        //console.log(unselectedProductList.length)
        //console.log(JSON.parse('<%= request.getAttribute("ProductList") %>'))
        //Add the unselectedList of unselected products
        for (var i = 0; i < unselectedProductList.length; i++){
            setClassId = unselectedProductListIds[i]+"unselected"
            //Create div
            di = document.createElement('div');
            di.setAttribute("class","wrap-flex listItem")
            di.setAttribute("id",setClassId+"Item");
            //Create input checkbox
            inp = document.createElement('input')
            inp.type="checkbox"
            inp.setAttribute("id",setClassId)
            inp.addEventListener("change", changeSelectProductLists);
            //Create label
            lab = document.createElement('label');
            lab.innerHTML = unselectedProductList[i]
            lab.setAttribute("for",setClassId)
            lab.setAttribute("class",setClassId+"Label")
            //Append thing
            di.append(inp)
            di.append(lab)
            document.getElementById("unselectedProducts").append(di)
            console.log("ITEM");
        }
        //Add to the selected
        function changeSelectMedicineLists(event){
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
                inp.addEventListener("click", changeSelectMedicineLists);
                inp.setAttribute("checked",true)
                
                //Create label
                lab = document.createElement('label');
                //console.log(unselectedMedicineList)
                for (var key in avaliableMedicineList) {
                    
                    if (avaliableMedicineList.hasOwnProperty(key)) {
                        if (avaliableMedicineList[key].id_product == idNum){
                            lab.innerHTML = avaliableMedicineList[key].name
                        }
                    }
                }
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
            changingMedicineResults()
        }
        function changeSelectProductLists(event){
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
                inp.addEventListener("click", changeSelectProductLists);
                inp.setAttribute("checked",true)
                
                //Create label
                lab = document.createElement('label');
                //console.log(unselectedProductList)
                for (var key in avaliableProductList) {
                    
                    if (avaliableProductList.hasOwnProperty(key)) {
                        if (avaliableProductList[key].id_product == idNum){
                            lab.innerHTML = avaliableProductList[key].name
                        }
                    }
                }
                lab.setAttribute("for",setClassId)
                lab.setAttribute("class",setClassId+"Label")
                //Append thing
                di.append(inp)
                di.append(lab)
                document.getElementById("selectedProducts").append(di)
            }else{
                console.log(idNum+"selectedItem")
                document.getElementById(idNum+"unselected").checked = false
                const deleteDiv = document.getElementById(idNum+"selectedItem").remove()
            }
            changingMedicineResults()
        }
        function changingMedicineResults(){
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
            for (i = 0; i < document.getElementById("selectedProducts").children.length; i++){
                idNum = ""
                for(j = 0; j < idString.length; j++){
                    const char = document.getElementById("selectedProducts").children[i].children[0].id.charAt(j);
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
