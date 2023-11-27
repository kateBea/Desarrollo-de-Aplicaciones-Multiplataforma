===========================================================================
Aplicación Node de chat interactivo.

Autor: Hugo Pelayo
Fecha: 26 nov 2023
===========================================================================

Esta es una pequeña aplicación de que simula un chat interactivo
mediante comunicaciones UDP entre clientes y servidor encriptadas 
simétricamente.

Podemos usar el comando --degub-enabled para mostrar por consola información
de los datos que va procesando el cliente o el servidor y los resultados que genera. 
Si queremos desabilitar esta información usamos --degub-disabled.

Con node servidor.js --help nos saldrá una pequeña ayuda de estos dos comandos básicos del servidor.
Con node cliente.js --help nos saldrá una pequeña ayuda de estos dos comandos básicos del cliente.

El servidor se cierra automáticamente después de 1 minuto de inactividad.

===========================================================================

1. Imprescindible antes de conectarse iniciar el servidor.

    node servidor.js --debug-disabled

2. Entonces podremos conectarnos como clientes.

    node cliente.js nombre_cliente --debug-disabled