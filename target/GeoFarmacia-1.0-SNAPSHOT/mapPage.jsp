<%-- 
    Document   : mapPage
    Created on : Jun 22, 2024, 7:59:07 PM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <style>
        .flex{
            flex-wrap: wrap;
            display:flex;
        }
        #map{
            height:80vh;
            width:100%;
        }
        .ejemplo{
            background:rgb(188, 236, 188);
        }
    </style>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="flex">
            <form action="">
                <input type="submit" value="regresar">
            </form>
            <form action="PharmacySearch">
                <input type="submit" value="Buscar farmacias">
            </form>
            <form action="medicineSearch">
                <input type="submit" value="Buscar medicinas">
            </form>
        </div>
        <div id="map"></div>
    </body>
    <script async
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDpkADYgeGaAX2CF7cjJd7M7VTSMGKhkok&loading=async&callback=initMap">
    </script>
    <script>
        /*
        (g=>{var h,a,k,p="The Google Maps JavaScript API",c="google",l="importLibrary",q="__ib__",m=document,b=window;b=b[c]||(b[c]={});var d=b.maps||(b.maps={}),r=new Set,e=new URLSearchParams,u=()=>h||(h=new Promise(async(f,n)=>{await (a=m.createElement("script"));e.set("libraries",[...r]+"");for(k in g)e.set(k.replace(/[A-Z]/g,t=>"_"+t[0].toLowerCase()),g[k]);e.set("callback",c+".maps."+q);a.src=`https://maps.${c}apis.com/maps/api/js?`+e;d[q]=f;a.onerror=()=>h=n(Error(p+" could not load."));a.nonce=m.querySelector("script[nonce]")?.nonce||"";m.head.append(a)}));d[l]?console.warn(p+" only loads once. Ignoring:",g):d[l]=(f,...n)=>r.add(f)&&u().then(()=>d[l](f,...n))})
        ({key: "AIzaSyB41DRUbKWJHPxaFjMAwdrzWzbVKartNGg", v: "weekly"});*/
        async function initMap() {
            const { Map } = await google.maps.importLibrary("maps");
            var myLatlng = new google.maps.LatLng(-25.363882,131.044922);
            var mapOptions = {
            zoom: 4,
            center: myLatlng
            }
            var map = new google.maps.Map(document.getElementById("map"), mapOptions);

            var marker = new google.maps.Marker({
                position: myLatlng,
                title:"Hello World!"
            });

            // To add the marker to the map, call setMap();
            marker.setMap(map);
            const contentString =
                '<div id="content">'+
                '<h1>TITULO</h1>'+
                '<p>'+
                'Ejemplo del marcador'+
                'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis sollicitudin tellus neque, id finibus lorem varius in. Nullam pellentesque malesuada nunc, non posuere lorem. Proin ac orci lorem. Suspendisse accumsan consequat velit quis cursus. Interdum et malesuada fames ac ante ipsum primis in faucibus. Maecenas varius efficitur metus, sed ultricies sapien pulvinar non. Donec sit amet lectus a augue lobortis aliquam. Phasellus nec egestas diam.'+
                '</p>'+
                '<p class="ejemplo">estilo</p>'+
                '</div>';
            const infowindow = new google.maps.InfoWindow({
                content: contentString,
                ariaLabel: "Uluru",
            });
            marker.addListener("click", () => {
                infowindow.open({
                anchor: marker,
                map,
                });
            });
            //map.setOptions({ styles: styles["hide"] });
        }

        initMap();
    </script>
</html>

