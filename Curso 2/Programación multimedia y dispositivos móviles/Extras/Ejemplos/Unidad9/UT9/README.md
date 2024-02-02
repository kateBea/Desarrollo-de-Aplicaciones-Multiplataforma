# UT9 Persistencia 

## Shared Preferences
Em el módulo "demo_memoria".  

## Memoria interna
En el módulo "demo_memoria"


## Room
### Primer ejemplo CRUD

En el módulo "crud_room"  

1. Creamos el modulo **CRUD_Romm** 
2. Añadimos las dependencias y plugin segun UT9.3
3. Creamos los paquetes:
    * modelo (DTO)
    * repositorio 
    * dominio (entities)
    * data
   
4. Y en ui el paquete de pantallas y navegacion
5. Creamos la clase entidad.Usuario
6. Creamos la clase abstracta data.BaseDatos
7. Creamos el interfaz modelo.UsuarioDao
8. Creamos viewmodel.UsuarioState y viewmodel.usuarioViewModel
9. Navegacion . Primero las dependencias luego creamos la función ui.navegacion.NavUsuario


### Creamos las ventanas

### Usando Relaciones

Añadimos una nueva tablas. Tareas con un id y descripción

1. Creamos la clase entidad.Tarea
2. Creamos el interfaz modelo.TareaDao
3. Creamos la clase intermedia para modelizar la relación
   * Añadimos id de usuario en la tarea.
   * Creamos la clase intermedia UsuarioTarea
   * Añadimos un metodo para la relacion en UsuarioDao
4. En BaseDatos añadimos la nueva entidad Tarea y el método    abstract fun tareaDao(): TareaDao


## Content Provider 

En el módulo App
Vamos a crear una aplicación que muestra una lista de contactos del telefono

1. Añadir permisos