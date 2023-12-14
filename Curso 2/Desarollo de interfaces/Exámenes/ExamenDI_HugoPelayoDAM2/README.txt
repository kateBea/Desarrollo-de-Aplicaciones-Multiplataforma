==========================================================

Cambios relevantes de Backend (lado servidor):


He añadido el products.controller.js (en server/controllers/products.controller.js) que en ese fichero gestiono las peticiones del cliente desde el lado del servidor. Solo tengo dos, registrar una nuevo producto y otra petición para consultar la lista de productos registrados.

En el fichero validator.middlewares (en server/src/middlewares/validator.middleware.js) tengo un validador de esquemas, por el cual un nuevo modelo antes de trabajar con el en la base de datos. Se asegura de que es válido en cuyo caso procede con el registro.

En productos.model.js (en server/src/models/productos.model.js) tengo definido el esquema de datos para mongoDB de nuestros productos, por simplicidad el precio se recoge como string pero se guarda como un real.

Y para acabar en schemas tenemos product.schema.js (en server/src/schemas/product.schema.js) que representa el esquema de datos que esperamos por parte del cliente.

En app.js he añadido app.use(rutasProductos); para habilitar las rutas de productos.


==========================================================

Ejecutar servidor:

cd server
npm install
npm run dev

Ejecutar cliente:

cd client
npm install
npm run dev
