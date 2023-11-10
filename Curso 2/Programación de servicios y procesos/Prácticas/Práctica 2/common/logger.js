'use strict';

const winston = require('winston');

// controlará si queremos o el logger
let debugEnable = true;

const ERROR_LEVEL = 0;

// Niveles de logging
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

// Colores para logging
winston.addColors(config.colors);

// creamos el logger
const logger = winston.createLogger({
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

function Error(message) {
    logger.error(`[${new Date(Date.now()).toLocaleTimeString()}] ${message}`);
}

function Debug(message) {
    logger.debug(`[${new Date(Date.now()).toLocaleTimeString()}] ${message}`);
}

function Warn(message) {
    logger.warn(`[${new Date(Date.now()).toLocaleTimeString()}] ${message}`);
}

function Info(message) {
    logger.info(`[${new Date(Date.now()).toLocaleTimeString()}] ${message}`);
}

// mostrar todos los logs hasta el nivel indicado
function SetLogginLevel(value) {
    debugEnable = value;
}

// Módulos exportados
exports.Error = Error;
exports.Debug = Debug;
exports.Warn = Warn;
exports.Info = Info;
exports.SetLogginLevel = SetLogginLevel;

exports.ERROR_LEVEL = ERROR_LEVEL;