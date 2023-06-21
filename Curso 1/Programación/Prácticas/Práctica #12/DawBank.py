# Fichero: DawBank.py
# Fecha: 17 de junio de 2023
# Autor: Hugo Pelayo

from CuentaBancaria import *

class DawBank:
    @classmethod
    def mostrar_menu(cls):
        menu = \
        """
        1. Mostrar datos de la cuenta
        2. Mostrar IBAN
        3. Mostrar titular
        4. Mostrar saldo
        5. Realizar ingreso
        6. Realizar retirada
        7. Mostrar movimientos
        8. Terminar programa
        """
        print(menu)
    
    @classmethod
    def crear_cuenta(cls):
        correcto = False

        while not correcto:
            titular = input('Introduzca el titular de la cuenta: ')
            iban = input('Introduzca el IBAN de la cuenta: ')

            try:
                cuenta = CuentaBancaria(iban, titular)
                correcto = True
                print('Cuenta creada con éxito')
            except IBANInvalidoError as err:
                print(str(err))
        return cuenta

    @classmethod
    def procesar_opcion(cls, opcion, cuenta):
        if opcion == 1:
            print(f'IBAN: {cuenta.iban}\nTitular: {cuenta.titular}\nSaldo: {cuenta.saldo}')
        elif opcion == 2:
            print(f'IBAN: {cuenta.iban}')
        elif opcion == 3:
            print(f'Titular: {cuenta.titular}')
        elif opcion == 4:
            print(f'Saldo: {cuenta.saldo}')
        elif opcion == 5:  
            valor_ingreso = float(input('¿Cuánto desea ingresar?')) 
            try:
                cuenta.ingresar(valor_ingreso)
            except MovimientoRelevante as excep:
                print(str(excep))
        elif opcion == 6:
            valor_retirada = float(input('¿Cuánto desea retirar?')) 
            try:
                cuenta.retirar(valor_retirada)
            except MinimiNegativo as excep:
                print(str(excep))
        elif opcion == 7:
            for movimiento in cuenta.movimientos:
                print(movimiento)

    @classmethod
    def main(cls):
        run = True
        cuenta = DawBank.crear_cuenta()
        while run:
            DawBank.mostrar_menu()
            opcion = int(input('\tTeclee opción: '))

            if opcion == 8:
                run = False
            else:
                DawBank.procesar_opcion(opcion, cuenta)


if __name__ == '__main__':
    DawBank.main()