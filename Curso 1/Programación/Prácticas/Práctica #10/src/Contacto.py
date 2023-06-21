# File: Contacto.py
# Author:
# Date: 9 de junio de 2023

class Contacto:
    def __init__(self, nombre, telf):
        """

        :param nombre:
        :param telf:
        """
        self._nombre = nombre
        self._telf = telf

    @property
    def nombre(self):
        """

        :return:
        """
        return self._nombre

    @property
    def telefono(self):
        """

        :return:
        """
        return self._telf

    @nombre.setter
    def set_nombre(self, nombre):
        """

        :param nombre:
        :return:
        """
        self._nombre = nombre

    @telefono.setter
    def set_telf(self, telf):
        """

        :param telf:
        :return:
        """
        self._telf = telf

    def __eq__(self, other):
        """

        :param other:
        :return:
        """
        return self._nombre == other._nombre and self._telf == other._telf

    def __str__(self):
        """

        :return:
        """
        return str.format(f'[{self._nombre}, {self._telf}]')
