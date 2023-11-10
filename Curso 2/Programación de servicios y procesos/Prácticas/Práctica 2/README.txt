=========================================================
Aplicación Node de gestión de archivos en la nube

Autor: Hugo Pelayo
Fecha: 8 nov 2023
=========================================================

Esta es una pequeña aplicación de gestión de 
archivos en un servidor local. Necesario iniciar
el servidor a través del script en la carpeta raíz
(init-server.sh), a partir de entonces podemos lanzar
comandos desde el cliente. Los posibles comandos son:

    1. listado: Saca una lista de los archivos en el 
    servidor y el número de bytes disponibles.

    Ejemplo: node cliente.js pepe 12345 listado


    2. subir: Sube un archivo al servidor.

    Ejemplo: node cliente.js pepe 12345 subir archivo.txt


    3. descargar: Descarga un archivo del servidor y lo 
    almacena en la carpeta en la que se esté ejecutando 
    el cliente.

    Ejemplo: node cliente.js pepe 12345 descargar archivo.txt


    4. borrar: Borra un archivo del servidor.

    Ejemplo: node cliente.js pepe 12345 borrar archivo.txt

Para más más comodidad al ejecutar las prueba, recomendable
ejecutar el servidor en una terminal (npm init-server) y en otro
ejecutar los casos de prueba. Tenemos disponibles varios casos
prueba a través de los comando:

npm run test-subir      (pruebas de subida de archivos)
npm run test-bajar      (pruebas de descarga de archivos)
npm run test-listado    (pruebas de listado de archivos)
npm run test-borrar     (pruebas de borrado de archivos)
