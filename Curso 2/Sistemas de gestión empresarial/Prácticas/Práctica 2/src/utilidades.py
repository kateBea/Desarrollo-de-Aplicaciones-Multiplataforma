import os

from pathlib import Path
from tkinter import PhotoImage

# Colores
COLOR_HEAD_FOOT = "#A5049E"
COLOR_PRINCIPAL = "#D805CD"
COLOR_LEFT = "#B805AF"
COLOR_FONT = "#FEFEFE"
COLOR_FOND_SECOND = "#7A0374"

MODULE_BUTTONS_CORNER_RADIUS = 5

def quoted_string(str):
    return "'" + str + "'"

def load_image(path) -> PhotoImage:
    return PhotoImage(file=path)

def parent_path_from_file(file) -> Path:
    current = Path(os.path.dirname(file))
    
    return Path(current.parent)

def current_file_path(file) -> Path:
    return Path(os.path.dirname(file))