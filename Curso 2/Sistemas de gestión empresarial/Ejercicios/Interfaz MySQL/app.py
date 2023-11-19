from gui import *
from db_connector import *

# conexión
host = input("host address: ")
user = input("user name: ")
password = input("password value: ")
connector = DBConnection(host, user, password);

# Interfaz
gui = GUI(connector.db.cursor())
gui.mainloop()