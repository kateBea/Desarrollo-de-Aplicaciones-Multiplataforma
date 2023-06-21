# File: Agenda.py
# Author:
# Date: 9 de junio de 2023

from Contacto import Contacto
from ContactoEmpresa import ContactoEmpresa
from ContactoPersona import ContactoPersona

class Agenda:
    def __init__(self, file_directory):
        self._permisos = 'r+'
        self._fichero_de_contactos = open(file_directory, self._permisos)
        self._contactos = list()

        self._get_contactos_de_fichero()

    @property
    def contactos(self):
        return self._contactos
    
    def _crear_contacto(self, datos):
        # Eliminar espacios en blanco innecesarios
        datos[0] = datos[0].strip()
        datos[1] = datos[1].strip()
        datos[2] = datos[2].strip()
        datos[3] = datos[3].strip()

        if datos[3] == 'empresa':
            return ContactoEmpresa(datos[0], datos[1], datos[2])
        elif datos[3] == 'persona':
            return ContactoPersona(datos[0], datos[1], datos[2])

    def _get_contactos_de_fichero(self):
        linea = self._fichero_de_contactos.readline()
        while len(linea) > 0:
            # Si la línea empieza con '//' se ignora ya que es un comentario
            if linea.startswith('//') or linea.isspace():
                linea = self._fichero_de_contactos.readline()
                continue

            contacto = linea.split(',')
            self._contactos.append(self._crear_contacto(contacto))
            linea = self._fichero_de_contactos.readline()

    def add_contacto(self, contacto):
        if self._contactos.count(contacto) != 0:
            print(f"El contacto {contacto} ya existe")
        else:
            self._contactos.append(contacto)
            self.escribir_contacnto(contacto)

    @classmethod
    def formatear_contacto(cls, contacto):
        dato = contacto.web if isinstance(contacto, ContactoEmpresa) else contacto.cumple
        tipo_dato = 'WEB' if isinstance(contacto, ContactoEmpresa) else 'CUMPLEAÑOS'
        tipo_contacto = 'empresa' if isinstance(contacto, ContactoEmpresa) else 'persona'

        linea = f'NOMBRE: {contacto.nombre}\nTELÉFONO: {contacto.telefono}\n{tipo_dato}: {dato}\nTIPO DE CONTACTO: {tipo_contacto}\n'

        return linea
            
    def escribir_contacnto(self, contacto):
        linea = Agenda.formatear_contacto(contacto)
        # Posicionar puntero letctura escritura al final
        self._fichero_de_contactos.seek(0, 2)
        self._fichero_de_contactos.write(linea)

    def remove_contacto(self, nombre):
        # list.count retorna el número de veces que aparece el contacto
        encontrado = False
        indice = 0

        while indice < len(self._contactos) and not encontrado:
            encontrado = self._contactos[indice].nombre == nombre

            if not encontrado:
                indice += 1

        if not encontrado:
            # El contacto no existe
            print(f"El contacto {contacto} no existe")
        else:
            # No hace falta reiterar ya que los contactos no se repiten
            self._contactos.remove(self._contactos[indice])
            print(f'Contacto {contacto} eliminado con éxito de la agenda')

            self._fichero_de_contactos.truncate(0)

            for contacto in self._contactos:
                dato = contacto.web if isinstance(contacto, ContactoEmpresa) else contacto.cumple
            tipo_dato = contacto.web if isinstance(contacto, ContactoEmpresa) else contacto.cumple
            tipo_contacto = 'empresa' if isinstance(contacto, ContactoEmpresa) else 'persona'

            linea = f'{contacto.nombre}, {contacto.telefono}, {tipo_dato}, {tipo_contacto}\n'
            self._fichero_de_contactos.seek(0, 2)
            self._fichero_de_contactos.write(linea)

    def remove_contacto(self, indice):
        # se asume que el índice es válido

        # No hace falta reiterar ya que los contactos no se repiten
        contacto = self._contactos[indice]
        self._contactos.remove(contacto)
        print(f'Contacto {contacto} eliminado con éxito de la agenda')

        self._fichero_de_contactos.truncate(0)

        for contacto in self._contactos:
            dato = contacto.web if isinstance(contacto, ContactoEmpresa) else contacto.cumple
            tipo_dato = contacto.web if isinstance(contacto, ContactoEmpresa) else contacto.cumple
            tipo_contacto = 'empresa' if isinstance(contacto, ContactoEmpresa) else 'persona'

            linea = f'{contacto.nombre}, {contacto.telefono}, {tipo_dato}, {tipo_contacto}\n'
            self._fichero_de_contactos.seek(0, 2)
            self._fichero_de_contactos.write(linea)

    def existe_contacto(self, contacto):
        """

        :param contacto:
        :return:
        """
        return self._contactos.count(contacto) != 0

    def __str__(self):
        """

        :return:
        """
        result = str()
        indice = 1
        for contacto in self._contactos:
            result += str.format(f'{indice}.- {contacto}\n')
            indice = indice + 1

        return result

    def listar_contactos(self):
        """

        :return:
        """
        print('Mostrando lista de contactos:\n')
        print(self)

    def buscar_contacto(self, contacto):
        """

        :param contacto: Contacto a buscar
        :return: índice en el rango [0, total_contactos) si existe el contacto, -1 en caso contrario
        """

        ret = -1
        try:
            ret = self._contactos.index(contacto)
            return self._contactos[ret]
        except ValueError:
            print('El contacto no existe')
            return None
    
    def cerrar(self):
        self._fichero_de_contactos.close()

