# Fichero: App.py
# Fecha: 17 de junio de 2023
# Autor: Hugo Pelayo

from Administrador import *
from Almacen import *
from Articulos import *
from Cliente import *
from Date import *
from Persona import *
from Tienda import *
from Venta import *
from Carrito import *

class App:
    clientes = None
    articulos = None
    admin = None
    tienda = None

    @classmethod
    def _crear_interfaz(cls):
        App.datos_clientes()
        App.datos_articulos()
        App.datos_administrador()

    @classmethod
    def datos_clientes(cls):
        clientes = list()

        clientes.append(Cliente('Cristina Hernández', '12345678P', '644 88 22 99', 'hsdTTa22+', 'Bilbao'))
        clientes.append(Cliente('Sara Méndez', '87564321Y', '622 11 22 99', 'rybnaOs+', 'Barcelona'))
        clientes.append(Cliente('Victoria álvarez', '05748361O', '675 88 44 00', 'adjad+22', 'Barcelona'))
        clientes.append(Cliente('Santiago Giménez', '47594732W', '722 74 64 92', 'hhadbaHH', 'Madrid'))
        clientes.append(Cliente('Albert Osbort', '56483921T', '644 84 92 44', 'adaduYYt2', 'Madrid'))
        clientes.append(Cliente('Carlos Serrano', '57604731G', '694 74 98 22', 'auydbn6543+', 'Vicálvaro'))
        clientes.append(Cliente('Pablo Blay', '94637185J', '642 84 74 11', 'hdadkad+99', 'Madrid'))
        clientes.append(Cliente('Juanjo Cardenal', '48563721P', '633 23 11 99', 'mbad300p+', 'Barcelona'))

        App.clientes = clientes
    

    @classmethod
    def datos_articulos(cls):
        App.articulos = list()

        App.articulos.append(Libro(123, 7.44, 16, 'El arte de la guerra', 'Sun Tzu', 'Dojo Ediciones'))
        App.articulos.append(Libro(111, 1.44, 9, 'Rompe la barrera del no', 'Chris Voss', 'CONECTA'))
        App.articulos.append(Libro(121, 8.44, 22, 'Robert Greene & Joost Elffers', 'Las 48 leyes del poder', 'Espasa'))
        
        App.articulos.append(Disco(101, 5.42, 17, 'Revolver', 'The Beattles', 1966))
        App.articulos.append(Disco(172, 7.81, 12, 'Abbey Road', 'The Beattles', 1969))
        
        App.articulos.append(Pelicula(100, 9.99, 14, 'Auntie Edna', 'Animación', 'Ted Mathot'))

    @classmethod
    def datos_administrador(cls):
        almacen = Almacen()
        App.tienda = Tienda(almacen)

        for articulo in App.articulos:
            almacen.anadir_articulo(articulo)

        for cliente in App.clientes:
            App.tienda.registrar_cliente(cliente)
            
        App.admin = Administrador(3532.7, 'José Almeida', '46593754K', '722 33 44 12', 'shfdshTT-', App.tienda)

    @classmethod
    def mostrar_tipo_operaciones(cls):
        print('\n¿Qué tipo de operaciones desea realizar? ')
        print('1. Operaciones de administración')
        print('2. Operaciones de cliente')
        print('3. Salir del programa\n')

    @classmethod
    def mostrar_operaciones_admin(cls):
        print('\nOperaciones de administración:')
        print('1. Mostrar inventario de almacén')
        print('2. Mostrar inventario de artículo')
        print('3. Aumentar stock de artículo')
        print('4. Mostrar clientes')
        print('5. Buscar artículo\n')

    @classmethod
    def mostrar_operaciones_cliente(cls):
        print('\nOperaciones de cliente:')
        print('1. Darse de alta')
        print('2. Aumentar saldo')
        print('3. Buscar artículo')
        print('4. Añadir artículo a carrito')
        print('5. Eliminar artículo de carrito')
        print('6. Visualizar histórico de compras entre fechas\n')

    @classmethod
    def gestionar_operaciones_admin(cls):
        App.mostrar_operaciones_admin()

        opcion = int(input('\nTeclee opción: '))

        if opcion == 1:
            App.admin.mostrar_inventario_almacen()
        if opcion == 2:
            id_articulo = int(input('Teclee el id de artículo: '))
            App.admin.mostrar_inventario_articulo(id_articulo)
        if opcion == 3:
            id_articulo = int(input('Teclee el id de artículo: '))
            cantidad = int(input('Teclee el cantidad a añadir: '))
            App.admin.aumentar_stock_articulo(id_articulo, cantidad)
        if opcion == 4:
            App.admin.mostrar_clientes()
        if opcion == 5:
            id_articulo = int(input('Teclee el id de artículo: '))
            App.admin.buscar_articulo(id_articulo)
        

    @classmethod
    def gestionar_operaciones_cliente(cls):
        App.mostrar_operaciones_cliente()

        opcion = int(input('\nTeclee opción: '))

        if opcion == 1:
            nombre = input('Introduzca su nombre: ') 
            dni = input('Introduzca su DNI: ')  
            telefono = input('Introduzca su teléfono: ')  
            clave_de_acceso = input('Introduzca su clave de acceso: ')  
            direccion_entrega = input('Introduzca su direccion de entrega: ') 

            App.tienda.registrar_cliente(Cliente(nombre, dni, telefono, clave_de_acceso, direccion_entrega))
        if opcion == 2:
            dni = input('Introduzca su DNI: ')
            clave = input('Introduzca su clave de acceso: ')

            encontrado = False
            indice = 0

            while indice < len(App.tienda.clientes) and not encontrado:
                encontrado = App.tienda.clientes[indice].clave == clave and App.tienda.clientes[indice].dni == dni
                if not encontrado:
                    indice +=1

            if encontrado:
                cantidad = float(input('Introduza cantidad: '))
                App.tienda.clientes[indice].aumentar_saldo(cantidad)
            else:
                print('Credenciales incorrectos o no existe el cliente')

        if opcion == 3:
            id_articulo = int(input('Teclee el id de artículo: '))

            articulo = App.tienda.almacen.buscar_articulo(id_articulo)
        
            if articulo != None:
                print(articulo)
            else:
                print('El artículo no existe')
        if opcion == 5:
            dni = input('Introduzca su DNI: ')
            clave = input('Introduzca su clave de acceso: ')

            encontrado = False
            indice = 0

            while indice < len(App.tienda.clientes) and not encontrado:
                encontrado = App.tienda.clientes[indice].clave == clave and App.tienda.clientes[indice].dni == dni
                if not encontrado:
                    indice +=1

            if encontrado:
                id_articulo = float(input('Introduza identificador de producto: '))

                item = App.tienda.clientes[indice].get_item_carrito(id_articulo)

                if item != None:
                    App.tienda.almacen.aumentar_cantidad_articulo(id_articulo, item.cantidad)
                    App.tienda.clientes[indice].quitar_de_carrito(item)
                else:
                    print('No existe elemento en el carrito')

            else:
                print('Credenciales incorrectos o no existe el cliente')

        if opcion == 4:
            dni = input('Introduzca su DNI: ')
            clave = input('Introduzca su clave de acceso: ')

            encontrado = False
            indice = 0

            while indice < len(App.tienda.clientes) and not encontrado:
                encontrado = App.tienda.clientes[indice].clave == clave and App.tienda.clientes[indice].dni == dni
                if not encontrado:
                    indice +=1

            if encontrado:
                id_articulo = float(input('Introduza identificador de producto: '))
                cantidad = float(input('Introduza cantidad: '))

                if App.tienda.almacen.comprobar_disponibilad(id_articulo) >= cantidad:
                    App.tienda.almacen.disminuir_cantidad_articulo(id_articulo, cantidad)
                    App.tienda.clientes[indice].anadir_a_carrito(Elemento(id_articulo, cantidad))
                else:
                    print('El producto no está disponible, no existe o no hay suficientes existencias')
            else:
                print('Credenciales incorrectos o no existe el cliente')
            
        if opcion == 6:
            pass


    @classmethod
    def run(cls):
        App._crear_interfaz()
        run = True

        while run:
            App.mostrar_tipo_operaciones()
            opcion = int(input('\nTeclee opción: '))

            if opcion == 1:
                App.gestionar_operaciones_admin()

            if opcion == 2:
                App.gestionar_operaciones_cliente()

            if opcion == 3:
                run = False


if __name__ == '__main__':
    App.run()