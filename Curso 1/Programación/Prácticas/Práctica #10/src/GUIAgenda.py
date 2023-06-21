# File: GUIAgenda.py
# Author:
# Date: 9 de junio de 2023
import sys
from Agenda import *
from PyQt6.QtWidgets import QApplication, QMainWindow, QVBoxLayout, QWidget, QLabel, QLineEdit, QPushButton, QHBoxLayout, QListWidget, QMessageBox

class GUIAgenda(QMainWindow):
    def __init__(self, agenda):
        self._app = QApplication(sys.argv)

        super().__init__()

        self._agenda = agenda

        self._posicion_x = 300
        self._posicion_y = 300

        self._ancho = 400
        self._alto = 400

        self.setWindowTitle("Agenda")
        self.setGeometry(self._posicion_x, self._posicion_y, self._ancho, self._alto)

        # Widget principal
        self._widget_principal = QWidget(self)
        self.setCentralWidget(self._widget_principal)

        # Indicar diseño del Widget principal
        self._layout_principal = QVBoxLayout()
        self._widget_principal.setLayout(self._layout_principal)

        # Etiquetas y campos de texto
        self._label_nombre = QLabel("Nombre:")
        self._text_nombre = QLineEdit()
        self._label_telefono = QLabel("Teléfono:")
        self._text_telefono = QLineEdit()

        self._label_web = QLabel("Web:")
        self._text_web = QLineEdit()
        self._label_cumple = QLabel("Cumpleaños:")
        self._text_cumple = QLineEdit()

        # Botones
        self._btn_agregar = QPushButton("Agregar")
        self._btn_agregar.clicked.connect(self.agregar_contacto)
        self._btn_eliminar = QPushButton("Eliminar")
        self._btn_eliminar.clicked.connect(self.eliminar_contacto)

        # Diseño horizontal para botones
        self._layout_botones = QHBoxLayout()
        self._layout_botones.addWidget(self._btn_agregar)
        self._layout_botones.addWidget(self._btn_eliminar)

        # Lista de contactos
        self._lista_contactos = QListWidget()

        # Agregar los elementos al diseño principal
        self._layout_principal.addWidget(self._label_nombre)
        self._layout_principal.addWidget(self._text_nombre)
        self._layout_principal.addWidget(self._label_telefono)
        self._layout_principal.addWidget(self._text_telefono)
        
        self._layout_principal.addWidget(self._label_web)
        self._layout_principal.addWidget(self._text_web)
        self._layout_principal.addWidget(self._label_cumple)
        self._layout_principal.addWidget(self._text_cumple)


        self._layout_principal.addLayout(self._layout_botones)
        self._layout_principal.addWidget(self._lista_contactos)

        # Añadimos los contactos ya existentes
        for contacto in self._agenda.contactos:
            linea = Agenda.formatear_contacto(contacto)
            self._lista_contactos.addItem(linea)

    def agregar_contacto(self):
        nombre = self._text_nombre.text()
        telefono = self._text_telefono.text()
        web = self._text_web.text()
        cumple = self._text_cumple.text()

        if web and cumple:
            QMessageBox.warning(self, "Error", "Sólo puede ingresar el cumpleaños o la \nweb si el contaxto es de empresa o pernonal")
            return

        if nombre and telefono:
            # Contacto de empresa
            if web:
                contacto = ContactoEmpresa(nombre, telefono, web)
                self._agenda.add_contacto(contacto)
                linea = Agenda.formatear_contacto(contacto)
                self._lista_contactos.addItem(linea)

                self._text_nombre.clear()
                self._text_telefono.clear()

            # Contacto personal
            if cumple:
                contacto = ContactoPersona(nombre, telefono, cumple)
                self._agenda.add_contacto(contacto)
                linea = Agenda.formatear_contacto(contacto)
                self._lista_contactos.addItem(linea)

                self._text_nombre.clear()
                self._text_telefono.clear()
        else:
            QMessageBox.warning(self, "Error", "Debe ingresar nombre y teléfono.")

    def eliminar_contacto(self):
        indice = self._lista_contactos.currentItem()

        if indice:
            # self._lista_contactos.row(indice) devolverá el índice del contacto dentro de la lista
            # de contactos
            self._agenda.remove_contacto(self._lista_contactos.row(indice))
            self._lista_contactos.takeItem(self._lista_contactos.row(indice))
        else:
            QMessageBox.warning(self, "Error", "indicee un contacto.")

    def run(self):
        self.show()
        sys.exit(self._app.exec())
