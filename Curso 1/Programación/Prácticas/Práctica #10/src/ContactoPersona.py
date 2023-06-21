# File: ContactoPersona.py
# Author:
# Date: 9 de junio de 2023

from Contacto import Contacto

class ContactoPersona(Contacto):
    def __init__(self, nombre, telf, cumple):
        """

        :param nombre:
        :param telf:
        :param cumple:
        """
        super().__init__(nombre, telf)
        self._cumple = cumple

    @property
    def cumple(self):
        """

        :return:
        """
        return self._cumple

    def set_cumple(self, cumple):
        """

        :param cumple:
        :return:
        """
        if cumple < 0:
            print('Valor de cumpleaños negativo')
        else:
            self._cumple = cumple

    def __str__(self):
        """

        :return:
        """
        return str.format(f'Contacto persona: {super().__str__()}. Cumpleaños: {self._cumple}')