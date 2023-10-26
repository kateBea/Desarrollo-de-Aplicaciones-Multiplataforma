Los comandos se deben ejecutar desde la carpeta raíz, es decir, la carpeta donde se encuentra 
este fichero de texto.

Ejemplo de ejecución:

node src/calendario.js data/fechas.json src/ --degub-enabled

Podemos usar el comando --degub-enabled para mostrar por consola información
de los datos que va procesando el programa y los resultados que genera. Si queremos desabilitar
esta información usamos --degub-disabled.

Con node src/calendario.js --help nos saldrá una pequeña ayuda de estos dos comandos básicos.

Tenemos enlaces al principio de la página a través del offcanvas (clic sobre botón en lado superior izquierdo)
y en la parte inferior tenemos un navegable con enlaces a los diferentes calendarios.
