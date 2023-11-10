/**
 * Logging para depuración o visualización de datos por la consola. 
 * Version node: v18.18.0.
 * 
 * @author Hugo Pelayo
 * @version 1.0.0
 * */

"use strict";

/* Imports */

const winston = require('winston');


/* Globales */

var logger = null;


/**
 * Registra un mensaje de error en el logger.
 * @param {string} message - Mensaje de error a registrar.
 * */
function Error(message) {
    logger.error(`[${new Date(Date.now()).toLocaleTimeString()}] ${message}`);
}


/**
 * Registra un mensaje de depuración en el logger.
 * @param {string} message - Mensaje de depuración a registrar.
 * */
function Debug(message) {
    logger.debug(`[${new Date(Date.now()).toLocaleTimeString()}] ${message}`);
}


/**
 * Registra un mensaje de advertencia en el logger.
 * @param {string} message - Mensaje de advertencia a registrar.
 * */
function Warn(message) {
    logger.warn(`[${new Date(Date.now()).toLocaleTimeString()}] ${message}`);
}


/**
 * Registra un mensaje de información en el logger.
 * @param {string} message - Mensaje de información a registrar.
 * */
function Info(message) {
    logger.info(`[${new Date(Date.now()).toLocaleTimeString()}] ${message}`);
}


/**
 * Inicializa el logger con niveles de logging y colores configurados.
 * */
function InitLogger() {
    // niveles de logging
    const config = {
        levels: {
            error: 0,
            debug: 1,
            warn: 2,
            data: 3,
            info: 4,
            verbose: 5,
            custom: 6
        },
        colors: {
            error: 'red',
            debug: 'blue',
            warn: 'yellow',
            data: 'grey',
            info: 'green',
            verbose: 'cyan',
            custom: 'yellow'
        }
    };

    // colores para logging
    winston.addColors(config.colors);

    // creamos el logger
    logger = winston.createLogger({
        levels: config.levels,
        format: winston.format.combine(
            winston.format.colorize({ all: true }),
            winston.format.simple()
        ),
        transports: [
            new winston.transports.Console()
        ],
        level: 'custom'
    });
}

InitLogger();


/* Exportaciones del módulo */

exports.Error = Error;
exports.Debug = Debug;
exports.Warn = Warn;
exports.Info = Info;