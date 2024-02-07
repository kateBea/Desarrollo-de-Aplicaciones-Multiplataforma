import pdfkit
import jinja2
import os

from utilidades import *

this_file_path = current_file_path(__file__)
dato1 = "Segundo"
dato2 = "Desarrollo de Aplicaciones Multiplataforma"

misDatos = {'dato1': dato1, 'dato2': dato2}
ubicacion_plantillas = jinja2.FileSystemLoader(this_file_path)

miPlantilla = jinja2.Environment(loader=ubicacion_plantillas) 

ruta = os.path.dirname(__file__)
creacion_html = this_file_path + "/miPlantilla.html"

miHTML = miPlantilla.get_template(creacion_html)

formatoWeb = miHTML.render(misDatos)
config = pdfkit.configuration(wkhtmltopdf="/usr/bin/wkhtmltopdf")

salida = "output.pdf"
pdfkit.from_string(formatoWeb, salida, configuration=config)