# File: ContactoEmpresa.py
# Author:
# Date: 9 de junio de 2023

from Contacto import Contacto

class ContactoEmpresa(Contacto):
    def __init__(self, nombre, telf, web):
        """

        :param nombre:
        :param telf:
        :param web:
        """
        super().__init__(nombre, telf)
        self._web = web

    @property
    def web(self):
        """

        :return:
        """
        return self._web

    def set_web(self, web):
        """

        :param web:
        :return:
        """
        self._web = web

    def __str__(self):
        """

        :return:
        """
        return str.format(f'Contacto empresa: {super().__str__()}. Web: {self._web}')
