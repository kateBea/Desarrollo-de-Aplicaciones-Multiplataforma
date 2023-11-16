'''
Created on 30 ene 2023

@author: mariosantos
'''

from fpdf import FPDF

class PdfDAM(FPDF):
    
    #Le pasamos la horientación de la página 'P' o 'L', las Unidades, mm, cm, pt y el formato A4, Carta, etc    
    def CrearDocumento(self, Horientacion, UnidadMedida, Formato):
        self = FPDF(Horientacion, UnidadMedida, Formato)
        
        
    #Modificamos las propiedades de la fuente en Fuente, Formato (Bold, Italic, Normal, Cursiva) y el tamaño.   
    def ModificarFuente(self, familia, formato, tamanno):
        self.set_font(familia, formato, tamanno)
        
        
    #Annadimos una línea a nuestra celda.    
    def AnnadirLinea(self, ancho, alto, texto, marco, saltocarro, alineacion):
        self.cell(ancho, alto, texto, marco, saltocarro, alineacion)
    
    def ImprimirLinea(self, posiniy, posinix, posfiny, posfinx):
        self.line(posiniy, posinix, posfiny, posfinx)
        
    #Guardamos el documento con el nombre "nombre" y en la carpeta destino "destino". Si lo queremos guardar en la carpeta
    #en la que se encuentra el módulo .py, le pasamos a la variable destino una 'F'.   
    def SalvarDocumento(self, nombre, destino):
        self.output(nombre, destino)
        
        
    #Annadimos una página al documento.   
    def AnnadirPagina(self):
        self.add_page()
        
    def Encabezado(self):
        self.image('Logo.png',10,8,33)
        self.set_font('Arial', '', 15)
        self.cell(60)
        self.cell(100,10,'Segundo DAM - Villablanca',0,1,'C')
        self.cell(100,10,'Miguel',0,1,'C')
        self.line(1, 37, 250, 37)
        self.ln(18)
        
    def Pie(self):
        self.set_y(260)
        self.set_font('Arial','I',8)
        self.cell(0,10,'Page ' + str(self.page_no()),0,0,'C')
        
        
    
        
        
    