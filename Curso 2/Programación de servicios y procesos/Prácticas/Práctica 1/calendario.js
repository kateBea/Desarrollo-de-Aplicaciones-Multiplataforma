const fs = require("fs");
const debugEnabled = true;

let dataFilePath;
let dataFileContents;
let outputDirectory;

const RUN_ON_DEBUG = (runnable) => { if (debugEnabled) { runnable(); } }

function handleCommandLineArguments() {
    if (process.argv.length != 4) {
        console.log(
            "Número incorrecto de argumentos\n" +
            "usage: node calendario.js fechas.json ruta-salida"
        );

        return;
    }

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

    let ret = JSON.parse(dataFileContents);

    for (let calendarEntryIndex = 0; calendarEntryIndex < ret.length; ++calendarEntryIndex) {
        RUN_ON_DEBUG(() => { console.log(ret[calendarEntryIndex]) });
    }

}

handleCommandLineArguments();

dataFileContents = fs.readFileSync(dataFilePath, { encoding: "utf8", flag: "r" });

RUN_ON_DEBUG(() => { console.log(dataFileContents) });

parseJsonData();