## Descripcion
El programa lo que hace es ubicar farmacias, no solo ubicarlas, tambien mostrar los detalles de las mismas farmacias, tales como que medicinas esta vendiendo, que servicios ofrece y los horarios de estos mismos, y tambien un sistema de acceso de usuarios, los cuales pueden cambiar y agregar datos de ciertos segmentos (como medicinas, servicios, otros usuarios y productos que ofrecen los servicios)

## Analisis
La gente que no sabe donde encontrar su medicina, puede llegar a perder su tiempo buscando de farmacia en farmacia por el medicamento que busca, tambien existe el riesgo de que la farmacia que vende el medicamento este cerrada, aumenta el riesgo de que las enfermedades empeoren, se necesita una manera de ubicar farmacias por el medicamento

## Solucion
Crear una aplicacion que permita a los trabajadores de las farmacias y gerentes agregar y manejar informacion de la farmacia, tales como medicinas que venden, que productos venden, que servicios atienden, la ubicacion de estas mismas y manejar a los usuarios quienes trabajan en que farmacias, y para los clientes de esos trabajadores, desplegar un mapa el cual contenga marcadores los cuales desplieguen informacion y detalles de la farmacia

## Issues
### Could not start GlassFish Server: HTTP or HTTPS listener port is occupied while server is not running:

Abrir el archivo cmd (Presiona windows + R y luego escribe cmd, al final, presiona enter)
Escribe este siguiente comando: 
```
netstat -aon | find ":8080" | find "LISTENING"    netstat -aon | find ":8080" | find "LISTENING"
```
O TAMBIEN
```
netstat -aon | find ":8080" | find "LISTENING"    netstat -aon | find ":8000" | find "LISTENING"
```
Desplegara lo siguientes y localiza el PID (El numero a la derecha):
  TCP    0.0.0.0:8080           0.0.0.0:0              LISTENING       4428
  TCP    [::]:8080              [::]:0                 LISTENING       4428

Abre el administrador de tareas (ctrl + alt + delete)
Haz clic en mas detalles (Por si no lo has pulsado, esta en el fondo de administrador de tareas)
Luego ve a la pestaña de detalles, y despues busca por el PID que has obtenido en el cmd al poner el comando (Por ejemplo: 4428)
Al ser localizado, haz clic en finalizar tarea (Al fondo a la deerecha) y listo
### Error: The Google Maps JavaScript API could not load
Una de las soluciones involucra cambiar una linea de codigo:
remplazar:
```
(g=>{var h,a,k,p="The Google Maps JavaScript API",c="google",l="importLibrary",q="__ib__",m=document,b=window;b=b[c]||(b[c]={});var d=b.maps||(b.maps={}),r=new Set,e=new URLSearchParams,u=()=>h||(h=new Promise(async(f,n)=>{await (a=m.createElement("script"));e.set("libraries",[...r]+"");for(k in g)e.set(k.replace(/[A-Z]/g,t=>"_"+t[0].toLowerCase()),g[k]);e.set("callback",c+".maps."+q);a.src=`https://maps.${c}apis.com/maps/api/js?`+e;d[q]=f;a.onerror=()=>h=n(Error(p+" could not load."));a.nonce=m.querySelector("script[nonce]")?.nonce||"";m.head.append(a)}));d[l]?console.warn(p+" only loads once. Ignoring:",g):d[l]=(f,...n)=>r.add(f)&&u().then(()=>d[l](f,...n))})
        ({key: "API_KEY", v: "weekly"});
```
por:
```
<script async
        src="https://maps.googleapis.com/maps/api/js?key=API_KEY&loading=async&callback=initMap">
    </script>
```
Al usar esa pieza de codigo, aparece el mapa correctamente en la pagina, pero con el mensaje de "For developer purpose only" y hasta despliega el mensaje de: Esta página no puede cargar Google Maps correctamente.

Se soluciono el problema al habilitar el pago en google API Services

### Problemas al usar firebase
El programa no permite el uso de firebase

## Paginas y enlaces
/ (Principal): donde habran las opciones de buscar farmacias por cierto dato o buscar directamente la mas cercana

## Enlaces
- **/SearchByName**: Permite buscar farmacias por nombre de farmacia
- **/searchByMedicine:** Permite buscar farmacias por nombre del medicamente
- **/searchByService:** Permite buscar farmacias por nombre de un servicio (dropdown)
- **/searchMap?serviceName=():** Despliega una tabla con las farmacias encontradas, dependiendo si se llamo desde searchByName, Service, o medicine, filtrara por aquellos resultados, tambien se llega directamente si se selecciono buscar mas cercanas
- **/inicioSesion:** Permite al usuario ingresar, usuario y contraseña
- **/ProcessLogin:** Despues de inicio de sesion, revisara datos y despues ira al menu de - administracion si sesion es correcta
- **/farmacias:** Es el controller de farmacias, method sirve para el metodo, si no hay, desplegar tabla
- **/servicios:** Es el controller de servicios, method sirve para el metodo, si no hay, desplegar tabla
- **/productos:** Es el controller de productos, method sirve para el metodo, si no hay, desplegar tabla
- **/tipoProductos:** Es el controller de tipo de productos, method sirve para el metodo, si no hay, desplegar tabla
- **/usuarios:** Es el controller de usuarios, method sirve para el metodo, si no hay, desplegar tabla
- **/roles:** Es el controller de roles de usuario, method sirve para el metodo, si no hay, desplegar tabla
- **/modulos:** Es el controller de modulos, method sirve para el metodo, si no hay, desplegar tabla

