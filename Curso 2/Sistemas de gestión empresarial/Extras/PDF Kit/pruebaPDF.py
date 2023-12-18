####################################
#  Creado el 15/12/2023            #
#  Mario Santos                    #
#  Utilizando plantillas html      #
#  para generar pdf's.             #
####################################

#Debemos instalar:
# pip3 install jinja2  -> Esta librería me ayuda a trabajar entre python y las plantillas html.
# pip3 install pdfkit  -> Esta librería es la que va a generar el pdf.
# sudo apt-get install wkhtmltopdf  -> Esta librería me permite combinar los datos de un .html a un .pdf

import pdfkit
import jinja2
import os

#Inserto los datos que voy a mostrar en mi documento .pdf.

dato1 = "Segundo"
dato2 = "Desarrollo de Aplicaciones Multiplataforma"

#Creo un diccionario de datos que le voy a pasar luego al método render de la librería de Jinja2
misDatos = {'dato1': dato1, 'dato2': dato2}

#Empiezo a crear el environment en el que tengo creadas mis plantillas en formato html.
#El primer paso es decir la ubicación en la que guardamos nuestras plantillas.
#En esta primera instrucción con FileSystemLoader, situo al sistema en esa ubicación
ubicacion_plantillas = jinja2.FileSystemLoader('./') #Dónde están mis plantillas'''
#Con esta segunda instrucción creo esa ubicación a través de loader. En realidad carga todas las plantillas que tengamos en la ubicación
miPlantilla = jinja2.Environment(loader=ubicacion_plantillas) #Creamos el entorno de trabajo de las plantillas'''
#Dentro de la ubicación, le digo la plantilla que quiero utilizar.
ruta = os.path.dirname(__file__)
creacion_html = ruta + '/miPlantilla.html'

miHTML = miPlantilla.get_template(creacion_html)

#Creamos el fichero .html añadiendo los datos recogidos en nuestras variables desde python.
formatoWeb = miHTML.render(misDatos)

#Indicamos a la librería de pdfkit que vamos a trabajar con wkhtmltopdf, como es una herramienta
#externa a pip, necesito pasarle la ubicación en donde la hemos instalado.
#fijaros como la hemos instalado con el sudo apt-get install y no con pip3 install.
config = pdfkit.configuration(wkhtmltopdf='/usr/bin/wkhtmltopdf')
#definimos el nombre del fichero que estamos generando.
salida = 'pdf_generado.pdf'
#generamos el fichero, pasando primero el formato web, diciendo el nombre y el formato de salida
#y la libreria que se debe utilizar para hacer la exportación de html a pdf.
pdfkit.from_string(formatoWeb, salida, configuration=config)