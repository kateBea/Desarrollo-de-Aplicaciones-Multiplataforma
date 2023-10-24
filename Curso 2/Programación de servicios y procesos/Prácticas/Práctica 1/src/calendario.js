// Imports
const fs = require("fs");
const platillas = require("./plantillas.js");

// Constantes
const debugEnabled = true;
const RUN_ON_DEBUG = (runnable) => { if (debugEnabled) { runnable(); } }; // Ejecuta runnable si modo depuración está activo
const DAYS_OF_WEEK = ["Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"];

// Variables
let dataFilePath;
let dataFileContents;
let outputDirectory;
let usageValid = false;
let listaDeEventos;


function handleCommandLineArguments() {
    if (process.argv.length != 4) {
        console.log(
            "Número incorrecto de argumentos\n" +
            "usage: node calendario.js fechas.json ruta-salida"
        );

        return;
    }

    usageValid = true;

    dataFilePath = process.argv[2];
    outputDirectory = process.argv[3]; 

    // Debug
    RUN_ON_DEBUG(() => { console.log("Fichero JSON: " + dataFilePath) });
    RUN_ON_DEBUG(() => { console.log("Fichero salida: " + outputDirectory) });
}

function parseJsonData() {
    if (!fs.existsSync(outputDirectory)) {
        console.log("El directorio '" + outputDirectory + "' no existe");
        return;
    }

    listaDeEventos = JSON.parse(dataFileContents);

    for (let calendarEntryIndex = 0; calendarEntryIndex < listaDeEventos.length; ++calendarEntryIndex) {
        RUN_ON_DEBUG(() => { console.log(listaDeEventos[calendarEntryIndex]) });
    }

    listaDeEventos.sort(
        (lhs, rhs) => {
            if (lhs["dia"] < rhs["dia"]) return -1;
            if (lhs["dia"] > rhs["dia"]) return 1;

            return 0;
        }
    );
}

/**
 * 
 * @returns null si no hay datos, datos del ficherro jason en caso contrario
 * */
function readFileData() {
    if (!usageValid) {
        return;
    }

    dataFileContents = fs.readFileSync(dataFilePath, { encoding: "utf8", flag: "r" });
    RUN_ON_DEBUG(() => { console.log(dataFileContents) });
}


function makeDate(eventMap) {
    const date = eventMap["dia"].split("-");
    return new Date(date[2] + "-" + date[1] + "-" + date[0]);
}

/**
 * Genera el calendario HTML a partir de los datos del JSON
 * */
function generateHTML() {
    let terminado = false;
    let eventListIndex = 0;

    while (terminado) {
        beginYear();

        // handle first day of the year (a year might not start on monday)
        {
            beginWeek();

            for (let dayIndex = 0; dayIndex < WEEK_DAYS_COUNT; ++dayIndex) {
                if (Date(fromCurrentDayIndex == listaDeEventos[eventListIndex])) {
                    pushEvent(hora, motivo, color);
                }
            }

            endWeek();
        }

        endYear();
    }
}

/**
 * Lee los datos del fichero JSON indicado
 * */
function handleJSONData() {
    readFileData();
    parseJsonData();
}


handleCommandLineArguments();

if (usageValid) {
    handleJSONData();
    generateHTML();
}