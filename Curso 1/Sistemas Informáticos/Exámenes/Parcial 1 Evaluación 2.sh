# Hugo Pelayo Aseko
# Examen Comandos Sistemas informáticos
# 19 de abril de 2023

# Ejercicio 1
echo "Resultados del Ejericio 1"
# Primero creamos el fichyero tunombre.sh
# touch tunombre.sh 

sudo chmod 0700 tunombre.sh

# Ejercicio 2
echo "Resultados del Ejericio 2"
alias listar="ls -lha"

# Ejercicio 3
echo "Resultados del Ejericio 3"
# a)
mkdir PracticaLinux
cd PracticaLinux
mkdir Archivos Documentos

# b)
cd Archivos/
touch archivo1.txt archivo2.md archivo3.csv

# c)
cd ../Documentos
touch documento1.doc documento2.pdf documento3.ppt

# Ejercicio 4
echo "Resultados del Ejericio 4"
cd -

# Ejercicio 5
echo "Resultados del Ejericio 5"
vim archivo1.txt

# Escribimos texto:

# Capítulo I. EN un lugar de la Mancha, de cuyo nombre no quiero
# acordarme, no ha mucho tiempo que vivía un hidalgo de los de la lanza en
# astillero, adarga antigua, rocín flaco y galgo corredor

# Escape para insertar comandos de vim, insertamos comando de guardar con la letra 'w' y salimos del terminal utilizando la letra 's'

# Ejercicio 6
echo "Resultados del Ejericio 6"
cp *.??? ../Documentos/

# Ejercicio 7
echo "Resultados del Ejericio 7"
listar *.[!p]*

# Ejercicio 8
echo "Resultados del Ejericio 8"
grep "de" archivo1.txt -o | wc -w

# Ejercicio 9
echo "Resultados del Ejericio 9"
wc -w archivo1.txt

# Ejercicio 10
echo "Resultados del Ejericio 10"
uname --all
neofetch # si no está el comando neofetch habría que instalar con "sudo apt install neofetch" en distribuciones debian/ubuntu

# Ejercicio 11
echo "Resultados del Ejericio 11"
sudo shutdown 21:00

# Ejercicio 12
echo "Resultados del Ejericio 12"
sudo apt install vlc

# Ejercicio 13
echo "Resultados del Ejericio 13"
cat archivo1.txt

# Ejercicio 14
echo "Resultados del Ejericio 14"
sudo useradd pedro

# Ejercicio 15
echo "Resultados del Ejericio 15"
sudo passwd pedro
