Los ficheros package no se añaden a esta repo. A continuación
está el script JSON de este proyecto:

```JSON
{
  "name": "auth-system",
  "version": "1.0.0",
  "description": "Sistema de autenticación con funciones CRUD",
  "main": "src/index.js",
  "type": "module",
  "scripts": {
    "dev": "nodemon src/index.js"
  },
  "author": "Hugo Pelayo",
  "license": "MIT",
  "devDependencies": {
    "nodemon": "^3.0.1"
  },
  "dependencies": {
    "express": "^4.18.2",
    "bcrypt": "^2.4.3",
    "mongoose": "^8.0.0",
    "morgan": "^1.10.0",
    "jsonwebtoken": "^9.0.2",
    "cookie-parser": "1.4.6",
    "zod": "3.22.4"
  }
}

```