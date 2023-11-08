



const COMMAND_LINE_ARGS = process.argv;
const CASE_SUBIR = "test-case-subir";

let testCase;

function ParseComdLineARguments() {
    for (cmd in COMMAND_LINE_ARGS) {
        console.log(COMMAND_LINE_ARGS[cmd]);
    }

    testCase = COMMAND_LINE_ARGS[COMMAND_LINE_ARGS.length - 1];
}


function Run() {
    ParseComdLineARguments();

    switch(testCase) {
        case CASE_SUBIR:
            console.log("Ejecutando prueba subir");
            break;
    }
}


Run()