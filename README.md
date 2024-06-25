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

