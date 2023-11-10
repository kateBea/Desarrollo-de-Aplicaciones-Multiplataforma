===========================================================================
Aplicación Node de gestión de peticiones entre cliente y 
servidor mediante conexiones TCP. 

Autor: Hugo Pelayo
Fecha: 8 nov 2023
===========================================================================

Esta es una pequeña aplicación de gestión de 
archivos en un servidor local. Necesario iniciar
el servidor (instrucciones abajo de como iniciar el servidor), 
a partir de entonces podemos lanzar comandos desde el cliente. 
Los posibles comandos son:

    - listado: Saca una lista de los archivos en el 
    servidor y el número de bytes disponibles.
    Ejemplo: node cliente.js pepe 12345 listado


    - subir: Sube un archivo al servidor.
    Ejemplo: node cliente.js pepe 12345 subir archivo.txt


    - descargar: Descarga un archivo del servidor y lo 
    almacena en la carpeta en la que se esté ejecutando 
    el cliente.
    Ejemplo: node cliente.js pepe 12345 descargar archivo.txt


    - borrar: Borra un archivo del servidor.
    Ejemplo: node cliente.js pepe 12345 borrar archivo.txt

===========================================================================

1. Importante antes que nada instalar los módulos necesarios.
Ahora hay una única librería, winston, para las utilidades de logging:

    npm install

2. Es necesario tener el servidor corriendo para poder hacer las peticiones.
Para ello vamos a ejecutar el comando de ejecución init-server, que entre otras cosas
habilita el flag de ejecución para el usuario actual, ya que por temas de seguridad
en linux los archivos de script nuevos no tiene ningún permiso de ejecución:

    npm run init-server

3. Pruebas:

    Para más comodidad al ejecutar las pruebas, recomendable ejecutar 
    el servidor en una terminal  y en otro ejecutar los casos de prueba. 
    Tenemos disponibles varios casos prueba a través de los comando:

    npm run test-subir      (pruebas de subida de archivos)
    npm run test-bajar      (pruebas de descarga de archivos)
    npm run test-listado    (pruebas de listado de archivos)
    npm run test-borrar     (pruebas de borrado de archivos)

4. Cerrar el servidor. Para evitar tener que interrumpir la ejecución 
del servidor via SIGINT (Ctrl+C) desde terminal, tenemos un cliente admin
con credenciales { "usuario": "administrador", "contraseña": "YGWpDasGa123+" }.
Para cerrar el servidor realizamos una petición con comando cerrar usando 
estos credenciales:

    node cliente.js administrador YGWpDasGa123+ cerrar