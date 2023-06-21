# File: PruebaAgenda.py
# Author:
# Date: 9 de junio de 2023

from Agenda import Agenda
from Contacto import Contacto
from ContactoPersona import ContactoPersona
from ContactoEmpresa import ContactoEmpresa
from GUIAgenda import GUIAgenda

class PruebaAgenda:
    @classmethod
    def main(cls):
        agenda = Agenda('Desarollo-de-Aplicaciones-Multiplataforma/Curso 1/Programación/Prácticas/Práctica #10/src/Contactos.txt')
        agenda.listar_contactos()

        gui = GUIAgenda(agenda)
        gui.run()


if __name__ == '__main__':
    PruebaAgenda.main()