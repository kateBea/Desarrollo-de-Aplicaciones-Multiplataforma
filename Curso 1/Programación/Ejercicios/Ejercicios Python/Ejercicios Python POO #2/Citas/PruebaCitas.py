from Cita import *
from Mascota import *
from Cliente import *

DIRECTORIO_FICHERO_MASCOTAS = 'mascotas.txt'
DIRECTORIO_FICHERO_CLIENTES = 'clientes.txt'
DIRECTORIO_FICHERO_CITAS =  'citas.txt'

clientes = list()
citas = list()
mascotas = list()

def generar_mascotas():
    with open(DIRECTORIO_FICHERO_MASCOTAS) as datosMascotas:
        line = datosMascotas.readline()

        while len(line) > 0:
            datos = line.split(',')
            mascotas.append(Mascota(int(datos[0]), datos[1].strip(), int(datos[2].strip())))
            line = datosMascotas.readline()

def generar_clientes():
    with open(DIRECTORIO_FICHERO_CLIENTES) as datosClientes:
        line = datosClientes.readline()

        while len(line) > 0:
            datos = line.split(',')
            clientes.append(Cliente(datos[0].strip(), datos[1].strip(), datos[2].strip(), datos[3].strip()))
            line = datosClientes.readline() 

def registrar_cita(identificador : int, tiempo : str, dni_cliente : str, id_mascota : int):
    existe_cliente = False
    existe_mascota = False

    indice_cliente = 0
    indice_mascota = 0

    # Busco el cliente
    while indice_cliente < len(clientes) and not existe_cliente:
        existe_cliente = clientes[indice_cliente].dni == dni_cliente

        if not existe_cliente:
            indice_cliente += 1

    # Busco la mascota
    while indice_mascota < len(mascotas) and not existe_mascota:
        existe_mascota = mascotas[indice_mascota].id == id_mascota

        if not existe_mascota:
            indice_mascota += 1

    if existe_cliente and existe_mascota:
        if not clientes[indice_cliente].es_amo_de(id_mascota):
            clientes[indice_cliente].adoptar(mascotas[indice_mascota])

        # Añadimos la cita
        citas.append(Cita(identificador, tiempo, clientes[indice_cliente], mascotas[indice_mascota]))


def generar_citas():
    with open(DIRECTORIO_FICHERO_CITAS) as datosCitas:
        line = datosCitas.readline()

        while len(line) > 0:
            datos = line.split(',')
            if not line.isspace():
                registrar_cita(int(datos[0]), datos[1].strip(), datos[2].strip(), int(datos[3]))

            line = datosCitas.readline() 
    
def mostrar_datos():
    # Mascotas
    print('Mascotas ------------------')
    for mascota in mascotas:
        print(mascota)

    # Clientes
    print('\nClientes ------------------')
    for cliente in clientes:
        print(str(cliente) + '\n')

    # Citas
    print('\nCitas ------------------')
    for cita in citas:
        print(cita)

def salvar_datos():
    with open(DIRECTORIO_FICHERO_CITAS, 'r+') as ficheroCitas:
        ficheroCitas.truncate(0)
        for cita in citas:
            line = f'{cita.id}, {cita.tiempo}, {cita.cliente.dni}, {cita.mascota.id}\n'
            ficheroCitas.write(line)

    with open(DIRECTORIO_FICHERO_CLIENTES, 'r+') as ficheroClientes:
        ficheroClientes.truncate(0)
        for cliente in clientes:
            line = f'{cliente.nombre}, {cliente.dni}, {cliente.email}, {cliente.telefono}\n'
            ficheroClientes.write(line)

    with open(DIRECTORIO_FICHERO_MASCOTAS, 'r+') as ficheroMascotas:
        ficheroMascotas.truncate(0)
        for mascota in mascotas:
            line = f'{mascota.id}, {mascota.nombre}, {mascota.edad}\n'
            ficheroMascotas.write(line)


def cargar_datos():
    generar_mascotas()
    generar_clientes()
    generar_citas()

    mostrar_datos()

    salvar_datos()

def main():
    cargar_datos()

if __name__ == '__main__':
    main()