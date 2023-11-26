import tkinter as tk; '''Importo tkinter para generar la interface. Le pongo el alias tk para no tener que estar escribiendo siempre tkinter'''

import conexionBBDD as cn;

'''Llamamos al método creado en nuestra clase para abrir la BBDD. Le pasamos como parámetros el huesped, el usuario y la password. Guardo la instanciación en miConexión para trabajar sobre esta conexión.'''

miConexion = cn.baseDatosDAM("localhost", "root", "123456");

'''Creo una base de datos con el método crear base de datos'''

miConexion.creacionBaseDeDatos('DAM');

miConexion.visualizarDatos("user", "mysql")

#miConexion.crearTabla("principal", "DAM");

#miConexion.eliminarTabla("principal", "DAM")

#miConexion.eliminacionBaseDeDatos('DAM');


miConexion.cerrarBBDD();


