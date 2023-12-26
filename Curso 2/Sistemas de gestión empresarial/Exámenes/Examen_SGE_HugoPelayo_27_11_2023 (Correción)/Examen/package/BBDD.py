import mysql.connector


class miBBDD():
    def __init__(self, datos1, datos2):
        self.datos1 = datos1
        self.datos2 = datos2

        self.conexion = mysql.connector.connect(
            host = "localhost",
            user = "root",
            password = "123456"
        )
        self.cursor = self.conexion.cursor()
        self.crearBaseDatos()
        self.crearTabla()
        self.guardarDatos()

    def crearBaseDatos(self):
        try:
            self.cursor.execute("create database if not exists examenDAM")
            print("Creada satisfactoriamente")
        except:
            print("No creada")


    def crearTabla(self):
        try:
            self.cursor.execute("use examenDAM;")
            self.cursor.execute("create table if not exists datosMigrados2(username varchar(40), email varchar(70), password varchar(40), nombreModulo varchar(40), nota1 varchar(2), nota2 varchar(2));")
            print("Tabla creada satisfactoriamente")
        except:
            print("Tabla no creada")

    def guardarDatos(self):
        linea = ""
        for j in self.datos1['usuario']:
            linea = 'insert into datosMigrados2 values ("' + j["username"] + '", "' + j["email"] + '", "' + j["password"]
            for z in self.datos2['notas']:
                if z['nombre'] == j['username']:
                    for i in z['modulos']:
                        linea = linea + '", "' + i['nombreModulo'] + '", "' + str(i['nota1']) + '", "' + str(i['nota2']) + '");'
            print(linea)
            self.cursor.execute("use examenDAM;")
            self.cursor.execute(linea)
            self.conexion.commit()
            linea = ""


        self.cursor.close()
        self.conexion.close()