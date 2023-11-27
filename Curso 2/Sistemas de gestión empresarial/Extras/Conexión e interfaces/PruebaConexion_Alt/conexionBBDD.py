import mysql.connector;  '''Importamos la librería connector, para poder conectarnos a nuestra base de datos Mysql que recordar que debe de estar arrancada desde Docker'''

'''Para arrancar la imagen de Mysql de docker utilizo el siguiente comando desde un terminal'''

'''$docker run -d -p 3306:3306 --name same-mysql -e MYSQL_ROOT_PASSWORD=123456 -d mysql'''

'''Recordar que en este comando el parámetro que le pasamos a --name es el nombre del contenedor de Docker de nuestra base de datos y que vosotros podéis poner el nombre que queráis. Lo mismo pasa con la contraseña que le paso al Root, le ponéis la que vosotros queráis, recordando que estamos con Docker y que no son datos persistentes.'''

'''Si os dice que ese contenedor ya existe, lo podéis borrar con la siguiente instrucción'''

'''$docker rm nombre_contenedor'''

'''Una vez arrancado el contenedor, podemos ingresar a Mysql desde un terminal lanzando el siguiente comando'''

'''$docker exec -it some-mysql mysql -u root -p'''

'''El nombre que le estoy pasando al parámetro -it es el nombre del contenedor que hemos creado al lanzar la primera orden que os he puesto en estos comentarios, en este caso es some-mysql'''

'''En este documento vamos a crear una clase que trabaje sobre la base de datos, haciendo conexiones y consultas'''


'''Creo la clase con class. En python, si heredamos de otra clase, se pasa entre los parénteis.'''

class baseDatosDAM():
    '''Como toda clase dispone de sus constructor, en el que vamos a definir todas las variables y todo lo que nos haga falta para poder trabajar con esta clase.'''
    '''este constructor viene definido por la siguiente función'''
    def __init__(self, huesped, usuario, contrasena):
        '''Muy importante el self, es lo que va a hacer referencia a todos los elementos situados en nuestra clase. Así mismo, todos los valores que le pasamos como entrada a esta clase, los recibimos en el init, por ejemplo 
        def __init__(self, nombre, edad)'''
        '''Importante, si heredamos de otra clase, debéis de definir, dentro de este constructor, el constructor de la super clase. por ejemplo '''
        ''' class baseDatosDAM(tkinter):
                def __init__(self):
                    super().__init__()
                    
        Si no hacemos esto, python entra en recursividad y la aplicación nos reportaría un herror.'''
        '''En este caso, dentro del constructor, voy a recibir los tres datos necesarios para hacer la conexión host, user, passord'''
        self.huesped = huesped
        self.usuario = usuario
        self.contrasena = contrasena
        '''de esta manera, ya tengo inicializadas mis variables para poder trabajar en la clase.'''
        self.conexionBBDD()
        

    def conexionBBDD(self):
        '''Hacemos la conexión a la base de datos. Como siempre cuando hacemos operaciones CRUD sobre la BBDD, utilizamos el try except'''
        try:
            self.conexion = mysql.connector.connect(
                host = self.huesped,
                user = self.usuario,
                password = self.contrasena
            )
            print("Base de Datos conectada")
            self.cursor = self.conexion.cursor()
            print("Cursor creado para poder lanzar comandos")
            
        except:
            print("No se ha conectado la base de datos")

    '''Crear una base de datos si no existe. Le pasamos como parámetro de entrada el nombre de la base de datos.'''

    def creacionBaseDeDatos(self, nombreBD):
        try:
            self.cursor.execute("create database if not exists " + nombreBD)
            print("Base de Datos " + nombreBD + ", creada")
        except:
            print("La base de datos no se ha creado")


    '''Eliminación de una base de datos'''
    def eliminacionBaseDeDatos(self, nombreBD):
        try:
            self.cursor.execute("drop database " + nombreBD)
            print("La base de datos se ha eliminado correctamente")
        except:
            print("La base de datos no se ha eliminado correctamente")

    '''Crear una tabla en la base de datos que hemos creado'''
    def crearTabla(self, nombreTabla, nombreDB):
        try:
            self.cursor.execute("use " + nombreDB)
            self.cursor.execute("CREATE TABLE " + nombreTabla + "(id int not null auto_increment, nombre varchar(10) not null, cargo varchar(10) not null, primary key(id));")
            print("Tabla creada satisfactoriamente")
        except:
            print("ocurrió algún error al crear la tabla")

    def eliminarTabla(self, nombreTabla, nombreBD):
        try:
            self.cursor.execute("use " + nombreBD)
            self.cursor.execute("drop table " + nombreTabla)
            print("La tabla se ha eliminado correctamente")
        except:
            print("No se ha borrado la tabla")


    '''Actualización de registros. En este caso el funcionamiento es similar a lo que hemos ido viendo a lo largo de los métodos.Os tenéis que acordar de pasar el self.conector.commit(). Esto es necesario para que se actualice el cambio que has realizado.COMO EJEMPO, vamos a suponer que queremos actualizar en la tipica tabla "clientes" una dirección. El método quedaría como sigue:'''
    def actualizarDatos(self, valorNuevo, valorViejo):
        try:
            self.cursor.execute("Update clientes set Address = 'Villablanca' where address = 'Madrid'")
            self.conexion.commit()
            print("Actualización correcta")
        except:
            print("No se ha actualizado correctamente la tabla")



    '''Leemos los datos de una consulta select a través del fetchall o fetchone'''
    def visualizarDatos(self, nombreTabla, nombreBD):
        try:
            self.cursor.execute("use " + nombreBD)
            self.cursor.execute("select * from " + nombreTabla)
            for registro in self.cursor:
                print(registro)

            '''cursor.execute("select * from user")
               print(cursor.fetchone())'''
        except:
            print("Ha ocurrido algún tipo de error en la lectura de la tabla")



    '''Cerramos la conexión con la base de datos'''
    def cerrarBBDD(self):
        try:
            self.cursor.close()
            print('Cierro el cursor')
            self.conexion.close()
            print("Base de datos cerrada")
        except:
            print("No se ha cerrado correctamente la base de datos")