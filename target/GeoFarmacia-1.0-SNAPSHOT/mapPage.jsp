<%-- 
    Document   : mapPage
    Created on : Jun 22, 2024, 7:59:07 PM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
    <%
        String positionText = request.getParameter("position");
    %>
    <title>Current Location</title>
    <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&callback=initMap" async defer></script>
    <style>
        #map {
            height: 500px;
            width: 100%;
        }
    </style>
</head>
<body>
    <h3>Current Location</h3>
    <div id="locationError" style="display: none; color: red;"></div>
    <div id="map"></div>
    <script async
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBBAAnKzvoX_Unpw-6ic36GTRqhFDalkYI&loading=async&callback=initMap">
    </script>
    <script>
        var marker;
        var map;
        var positionText = "<%=positionText%>";
        var position = positionText.split(",");
        console.log("POSITION: ",position);
        console.log("Latitude ",position[0]);
        console.log("Longitude ",position[1]);
        /*
        (g=>{var h,a,k,p="The Google Maps JavaScript API",c="google",l="importLibrary",q="__ib__",m=document,b=window;b=b[c]||(b[c]={});var d=b.maps||(b.maps={}),r=new Set,e=new URLSearchParams,u=()=>h||(h=new Promise(async(f,n)=>{await (a=m.createElement("script"));e.set("libraries",[...r]+"");for(k in g)e.set(k.replace(/[A-Z]/g,t=>"_"+t[0].toLowerCase()),g[k]);e.set("callback",c+".maps."+q);a.src=`https://maps.${c}apis.com/maps/api/js?`+e;d[q]=f;a.onerror=()=>h=n(Error(p+" could not load."));a.nonce=m.querySelector("script[nonce]")?.nonce||"";m.head.append(a)}));d[l]?console.warn(p+" only loads once. Ignoring:",g):d[l]=(f,...n)=>r.add(f)&&u().then(()=>d[l](f,...n))})
        ({key: "AIzaSyB41DRUbKWJHPxaFjMAwdrzWzbVKartNGg", v: "weekly"});*/
        async function initMap() {
            const { Map } = await google.maps.importLibrary("maps");
            var myLatlng = new google.maps.LatLng(position[0],position[1]);
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
            marker.addListener("click", () => {
                infowindow.open({
                anchor: marker,
                map,
                });
            });
            /*
            if (navigator.geolocation) {
                    navigator.geolocation.getCurrentPosition(
                        (position) => {
                            const pos = {
                                lat: position.coords.latitude,
                                lng: position.coords.longitude
                            };

                            // Move the marker to the new position
                            marker.setPosition(pos);
                            marker.setTitle("Current Location");

                            // Center the map at the new position
                            map.setCenter(pos);
                        },
                        () => {
                            handleLocationError({ code: 0 });
                        }
                    );
                } else {
                    // Browser doesn't support Geolocation
                    handleLocationError(false, map.getCenter());
                }*/
            //map.setOptions({ styles: styles["hide"] });
        }
        function handleLocationError(error) {
            const locationErrorDiv = document.getElementById("locationError");
            locationErrorDiv.style.display = "block";

            switch(error.code) {
                case error.PERMISSION_DENIED:
                    locationErrorDiv.innerHTML = "User denied the request for Geolocation. Please enable location services.";
                    break;
                case error.POSITION_UNAVAILABLE:
                    locationErrorDiv.innerHTML = "Location information is unavailable.";
                    break;
                case error.TIMEOUT:
                    locationErrorDiv.innerHTML = "The request to get user location timed out.";
                    break;
                case 0:
                default:
                    locationErrorDiv.innerHTML = "Tu navegador no soporta la ubicacion, o tiene que darle permiso a la ubicacion para usar maps.";
                    break;
            }
        }
        async function initMapAgain(lat,lon) {
            const { Map } = await google.maps.importLibrary("maps");
            var myLatlng = new google.maps.LatLng(lat,lon);
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
            marker.addListener("click", () => {
                infowindow.open({
                anchor: marker,
                map,
                });
            });
            //map.setOptions({ styles: styles["hide"] });
        }
        initMap();
        function gotoMexico() {
            if (!marker || !map) {
                console.error("Map or marker not initialized");
                return;
            }

            const newPosition = { lat: -35.297, lng: 149.644 };

            marker.setPosition(newPosition);
            map.setCenter(newPosition);
            map.setZoom(10);
        }
    </script>
</body>
</html>