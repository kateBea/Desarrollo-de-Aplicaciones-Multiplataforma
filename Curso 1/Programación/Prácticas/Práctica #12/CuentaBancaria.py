# Fichero: CuentaBancaria.py
# Fecha: 17 de junio de 2023
# Autor: Hugo Pelayo

import string

class IBANInvalidoError(Exception):
    def __init__(self, message):
        self._message = message
        super().__init__(self._message)


class MinimiNegativo(Exception):
    def __init__(self, message):
        self._message = message
        super().__init__(self._message)


class MovimientoRelevante(Exception):
    def __init__(self, message):
        self._message = message
        super().__init__(self._message)


class CuentaBancaria:
    MOVIMIENTO_NOTIFICACION_HACIENDA = 3000.0
    MAXIMO_MOVIMIENTOS = 100
    MINIMO_SALDO = -50

    def __init__(self, iban, titular):
        if not self._es_iban_valido(iban):
            raise IBANInvalidoError('Cadena IBAN inválida')

        self._iban = iban
        self._titular = titular
        self._saldo = 0.0
        self._movimientos = list()

    @property
    def iban(self):
        return self._iban

    @property
    def titular(self):
        return self._titular

    @property
    def saldo(self):
        return self._saldo

    @property
    def movimientos(self):
        return self._movimientos

    def ingresar(self, cantidad):
        if cantidad == 0:
            return

        self._saldo += cantidad
        self._movimientos.append(f'Se ha realizado retirada de {cantidad}. Saldo actual: {self._saldo}')

        if self._saldo > CuentaBancaria.MOVIMIENTO_NOTIFICACION_HACIENDA:
            raise MovimientoRelevante('AVISO: Notificar a hacienda')


    def retirar(self, cantidad):
        if cantidad == 0:
            return

        if (self._saldo - cantidad) < CuentaBancaria.MINIMO_SALDO:
            self._saldo = CuentaBancaria.MINIMO_SALDO
        else:
            self._saldo -= cantidad
        
        self._movimientos.append(f'Se ha realizado retirada de {cantidad}. Saldo actual: {self._saldo}')

        if self._saldo < 0.0:
            raise MinimiNegativo('AVISO: Saldo negativo')

    def _es_iban_valido(self, iban):
        MAX_LETRAS = 2
        MAX_DIGITOS = 22

        count_digitos = 0
        count_letras = 0

        for caracter in iban:
            if self._es_digito(caracter):
                count_digitos += 1

            if self._es_letra(caracter):
                count_letras += 1

        return count_digitos == MAX_DIGITOS and count_letras == MAX_LETRAS

    def _es_digito(self, caracter):
        return caracter in ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']

    def _es_letra(self, caracter):
        return caracter in string.ascii_uppercase
