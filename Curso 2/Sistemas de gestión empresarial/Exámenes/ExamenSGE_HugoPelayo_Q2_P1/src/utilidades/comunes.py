import os

from pathlib import Path
from tkinter import PhotoImage

COLOR_CAJA_LATERAL = "#B805AF"
COLOR_VENTANA_PRINCIPAL = "#D005C6"
COLOR_HEADER_FOOTER = "#A5049E"
COLOR_TEXTO_CURSO = "#800374"

MODULE_BUTTONS_CORNER_RADIUS = 2

LIMIT_DATA = 10

# Tiempos que pueden tardar los corredores entre puntos (en minutos)
TIEMPO_MIN = 10
TIEMPO_MAX = 15

def quoted_string(str) -> str:
    return f"'{str}'"

def parent_path_from_file(file) -> Path:
    current = Path(os.path.dirname(file))
    return Path(current.parent)

def load_image(filepath) -> PhotoImage:
    return PhotoImage(file=filepath)