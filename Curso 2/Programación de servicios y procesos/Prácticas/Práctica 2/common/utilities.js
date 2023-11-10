/**
 * Listado de funciones de utilidad. Version node: v18.18.0.
 * 
 * @author Hugo Pelayo
 * @version 1.0.0
 * */
"use strict"

const Fs = require("fs");
const Logger = require("./logger.js");


/* Constantes */

const CASE_SUBIR = "subir";
const CASE_BORRAR = "borrar";
const CASE_LISTADO = "listado";
const CASE_DESCARGAR = "descargar";


/**
 * Parsea una cadena JSON y devuelve el objeto resultante o null si hay un error.
 * @param {string} contentsStr - Cadena que contiene datos en formato JSON.
 * @returns {object | null} - Objeto resultante del análisis JSON (lista u objeto) o null si hay un error.
 * */
function ParseJSON(constentsStr) {
    let result = null;

    try {
        result = JSON.parse(constentsStr);
    }
    catch(err) {
        Logger.Error(`Error al parsear fichero JSON. Contenido:\n ${constentsStr}`)
    }

    return result;
}


/**
 * Cargar el contenido de un archivo de forma asíncrona.
 * @param {string} - nombreArchivo - El nombre del archivo a cargar.
 * @returns {Promise<string>} Una promesa que resuelve con el contenido del archivo o se rechaza con un error si la carga falla.
 * */
function CargarArchivo(nombreArchivo) {
    return new Promise((resolve, reject) => {
        Fs.readFile(nombreArchivo, 'utf8', (error, contenido) => {
            if (error) {
                reject(error);
            } 
            else {
                resolve(contenido);
            }
        });
    });
}


/**
 * Retorna un número aleatorio en el rango [lowerBound, upperBound].
 * @param {number} lowerBound - límite inferior.
 * @param {number} upperBound - límite superior.
 * @returns {number} - número aleatorio
 * */
function GenRandomInt(lowerBound, upperBound) {
    return parseInt(Math.random() * upperBound + lowerBound)
}


/* Exports del módulo */

exports.ParseJSON = ParseJSON;
exports.CargarArchivo = CargarArchivo;
exports.GenRandomInt = GenRandomInt;

exports.CASE_SUBIR = CASE_SUBIR;
exports.CASE_BORRAR = CASE_BORRAR;
exports.CASE_LISTADO = CASE_LISTADO;
exports.CASE_DESCARGAR = CASE_DESCARGAR;