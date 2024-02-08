import os
import json

from pathlib import Path
from tkinter import PhotoImage

# Colores
COLOR_HEAD_FOOT = "#A5049E"
COLOR_PRINCIPAL = "#D805CD"
COLOR_LEFT = "#B805AF"
COLOR_FONT = "#FEFEFE"
COLOR_FOND_SECOND = "#7A0374"

LIMIT_DATA = 100
MODULE_BUTTONS_CORNER_RADIUS = 5


def quoted_string(str) -> str:
    """
    Encloses the input string within single quotes.
    
    Parameters:
    - str (str): The string to be enclosed within single quotes.
    
    Returns:
    - str: The input string enclosed within single quotes.
    """
    return "'" + str + "'"


def load_image(path) -> PhotoImage:
    """
    Loads an image file from the specified path.
    
    Parameters:
    - path (str): The path to the image file.
    
    Returns:
    - PhotoImage: An object representing the loaded image.
    """
    return PhotoImage(file=path)


def parent_path_from_file(file) -> Path:
    """
    Retrieves the parent directory path of the specified file.
    
    Parameters:
    - file (str): The path to the file.
    
    Returns:
    - Path: The parent directory path of the specified file.
    """
    current = Path(os.path.dirname(file))
    return Path(current.parent)


def current_file_path(file) -> Path:
    """
    Retrieves the directory path of the specified file.
    
    Parameters:
    - file (str): The path to the file.
    
    Returns:
    - Path: The directory path of the specified file.
    """
    return Path(os.path.dirname(file))


def generate_json(data) -> str:
    """
    Generates a JSON string representation from the given data.
    
    Parameters:
    - data (object): The data to be converted to a JSON string.
    
    Returns:
    - str: The JSON string representation of the data.
    """
    return json.dumps(data)


def generate_json(data) -> str:
    """
    Generates a JSON string representation from the given data.
    
    Parameters:
    - data (object): The data to be converted to a JSON string.
    
    Returns:
    - str: The JSON string representation of the data.
    """
    return json.dumps(data)


def serialize_to_json_file(data, file) -> None: 
    """
    Serializes data to a JSON file.
    
    Parameters:
    - data (object): The data to be serialized.
    - file (str): The path to the JSON file.
    
    Returns:
    - None
    """
    with open(file, "w") as fichero:
        json.dump(data, fichero, indent=4)

    
def load_json_from_file(filepath) -> object:
    """
    Loads JSON data from a file and returns the corresponding Python object.
    
    Parameters:
    - filepath (str): The path to the JSON file.
    
    Returns:
    - object: The Python object representing the JSON data.
    """
    datos = None
    
    with open(filepath, "r") as fichero:
        datos = json.load(fichero)
        
    return datos

