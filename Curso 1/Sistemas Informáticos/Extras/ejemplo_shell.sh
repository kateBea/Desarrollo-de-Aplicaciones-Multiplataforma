#!/bin/bash
echo "Hello, world!"

read -p "nombre del archivo: " archivo


echo "el texto seleccionado es:"  $archivo
echo "el texto seleccionado es: $archivo"

if test $archivo = "adios2.txt";then
	cat $archivo
else
	echo  "no es el archivo"
fi
#declaracion de variables
declare -i var1=4
declare -i var2=5
#declare -i resultado 

#dos formas de asignar valores: con let o sin él
#también se puede asignar variables con $((operación))
let resultado=var1+var2
resultado2=$((var1+var2))

#dos formas de concatenar texto con variables
echo  "la suma es:" $resultado
echo "resultado2: $resultado2"

#bucles

#no hay que dejar espacios en la asignacion
continuar="y"
echo "el valor de continuar es "$continuar

#hay que dejar los espacios
while [ $continuar == "y" ]
do
	read -p "introduce mínimo: " min
	read -p "introduce máximo: " max
	cont=0
	for i in $(seq $min $max);do
		echo $i
		let cont++
	done
	echo "se repite "$cont" veces"
	read -p "¿Quieres volver a repetirlo? y/n " continuar
done

