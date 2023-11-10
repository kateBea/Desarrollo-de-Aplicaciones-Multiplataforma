Los package.json no se suben a esta repo:

```JSON
{
  "name": "tests",
  "version": "1.0.0",
  "description": "Pruebas para la aplicación client-server",
  "main": "tests/index.js",
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1",

    "init-server": "echo \"Chaning init-server script permissions to run server.\" && chmod +x init-server.sh && ./init-server.sh",
    "test-subir": "node tests/index.js test-case-subir",
    "test-bajar": "node tests/index.js test-case-bajar",
    "test-listado": "node tests/index.js test-case-listado",
    "test-borrar": "node tests/index.js test-case-borrar"
  },
  "author": "Hugo Pelayo",
  "license": "MIT",
  "dependencies": {
    "winston": "^3.11.0"
  }
}


```

For Fs.writeFile flag reference:
https://stackoverflow.com/questions/27920892/in-fs-writefileoption-how-an-options-parameter-generally-work
