# Trabajando con docker

```Shell
# Importar la imagen

docker pull mysql


# Ejecutar el contenedor (specificar puerto que usa docker), donde mysql-docker es el nombre de contenedor
# MYSQL_ROOT_PASSWORD es la contrasña del usuario root que es el usuario por defecto

docker run -d -p 3306:3306 --name mysql-docker -e MYSQL_ROOT_PASSWORD=123456 -d mysql:latest
``````
