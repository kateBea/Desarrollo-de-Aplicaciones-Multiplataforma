// Imports

const fs = require("fs");
const platillas = require("./plantillas.js");

// Constantes

let debugEnabled = true;                                                    // este parámetro se podrá modificar mediante comandos por consola
const RUN_ON_DEBUG = (runnable) => { if (debugEnabled) { runnable(); } };   // Ejecuta runnable si modo depuración está activo

const MONTHS_MAX = 12;
const WEEK_DAYS_MAX = 7;
const DAYS_OF_WEEK = ["Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"];
const MONTHS = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"];

// días por año (si el año es bisiesto, febrero tendrá 29 días, de lo contrario tendrá 29)
// este valor se ajusta cada vez que se va a generar un calendario
let dataFilePath;
let outputDirectory;
let calendarYears = [];
let daysPerMonth = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

let guidCount = 1;

/**
 * Muestra los comandos de este programa
 * */
function Help() {
    console.log(
        "Usage: node calendario.js fechas.json ruta-salida [OPTIONS]\n\n" +
        "OPTIONS:\n\n" +
        "  --debug-enable   ->  Habilitar los mensajes de depuración por consola\n" +
        "  --debug-disabled ->  Deshabilitar los mensajes de depuración por consola\n"
    );
}

/**
 * Muestra el uso y ayuda del programa
 * */
function Usage() {
    console.log(
        "Número incorrecto de argumentos\n" +
        "Usa 'node calendario.js --help' para desplegar la ayuda\n" +
        "Usage: node calendario.js fechas.json ruta-salida [OPTIONS]"
    );
}

/**
 * Determina de manera síncrona si la ruta representa un directorio
 * @param {string} dir ruta al directorio
 * @returns {boolean} cierto si la ruta es un directorio, falso en caso contrario
 * */
function IsValidDirectory(dir) {
    let result = false;

    if (fs.existsSync(dir)) {
        const stats = fs.lstatSync(dir);
        
        if (stats.isDirectory()) {
            RUN_ON_DEBUG(() => { console.log('El directorio es válido')} );
            result = true;
        } 
        else {
            console.error('La ruta no representa un directorio');
        }
    } 
    else {
        console.error('El directorio no existe');
    }

    return result;
}

/**
 * Determina de manera síncrona si la ruta representa un fichero
 * @param {string} file ruta al fichero
 * @returns {boolean} cierto si la ruta es un fichero, falso en caso contrario
 * */
function IsValidFile(file) {
    let result = false;

    if (fs.existsSync(file)) {
        const stats = fs.lstatSync(file);
        
        if (stats.isFile()) {
            RUN_ON_DEBUG(() => { console.log("El fichero es válido")} );
            result = true;
        } 
        else {
            console.error("La ruta no representa un fichero");
        }
    } 
    else {
        console.error('El directorio no existe');
    }

    return result;
}

/**
 * Valida los argumentos con que se ejecuta este script, retorna cierto
 * si el uso es válido, retorna falso en cualquier otro caso.
 * @returns {boolean} si los argumentos son válidos
 * */
function ParseCmdLineArguments() {
    if (process.argv.length < 3) {
        Usage();
        return false;
    }

    if (process.argv[2] == "--help") {
        Help();
        return false;
    }

    // si no se quiere la ayuda el cuarto argumento debe ser 
    // la ruta de salida tal y como como se indica en el uso, ver Usage()
    if (process.argv[3] == undefined) {
        Usage();
        return false;
    }
    
    if (process.argv[4] === "--debug-enable") {
        debugEnabled = true;
    }
    else if (process.argv[4] === "--debug-disabled") {
        debugEnabled = false;
    }

    dataFilePath = process.argv[2];
    outputDirectory = process.argv[3]; 

    // Debug
    RUN_ON_DEBUG(() => { console.log("Fichero JSON: " + dataFilePath) });
    RUN_ON_DEBUG(() => { console.log("Fichero salida: " + outputDirectory) });

    return true;
}

/**
 * Parsea un string en forma JSON y retorna sus datos
 * @param {string} contents string con los datos JSON
 * @returns {Array} datos de un string JSON
 * */
function GetParsedJSONData(contents) {
    let listaDeEventos = JSON.parse(contents);
    return listaDeEventos;
}

/**
 * Crea nun objeto Date de un objeto de la lista de eventos del JSON. Ver 
 * fichero data/fechas.json para detalles del formato de los datos
 * @param {Map} eventMap evento
 * @returns {Date} objeto Date correspodniente al evento
 * */
function MakeDate(eventMap) {
    const date = eventMap["dia"].split("-");
    return new Date(date[2] + "-" + date[1] + "-" + date[0]);
}

/**
 * Inserta el contenido HTML para comenzar un nuevo año.
 * @param {number} year - El año para el cual se desea comenzar.
 * @returns {string} - El contenido HTML para comenzar el año.
 * */
function BeginYear(year) {
    const calendarYearPlaceholder = "__CALENDAR_TITLE__";

    return platillas.BEGIN_YEAR.replaceAll(calendarYearPlaceholder, " " + year);
}

/**
 * Inserta el contenido HTML para finalizar el último año comenzado.
 * @param {string} yearStr - El contenido HTML del año que se desea finalizar.
 * @returns {string} - El contenido HTML para finalizar el año.
 * */
function EndYear(yearStr) {
    return yearStr + platillas.END_YEAR;
}

/**
 * Inserta el contenido HTML para comenzar una nueva semana.
 * @returns {string} - El contenido HTML para comenzar la semana.
 * */
function BeginWeek() {
    return platillas.BEGIN_WEEK;
}

/**
 * Inserta el contenido HTML para finalizar la última semana comenzada.
 * @param {string} weektStr - El contenido HTML de la semana que se desea finalizar.
 * @returns {string} - El contenido HTML para finalizar la semana.
 * */
function EndWeek(weektStr) {
    return weektStr + platillas.END_WEEK;
}

/**
 * Obtiene un identificador único.
 * @returns {number} - El identificador único generado.
 * */
function GetUUID() {
    return guidCount++;
}

/**
 * Inserta el contenido HTML para comenzar un nuevo día.
 * @param {number} dayIndex - El índice del día de la semana.
 * @param {number} weekLevel - El nivel de la semana.
 * @param {Date} date - La fecha del día.
 * @param {number} monthDay - El día del mes.
 * @returns {string} - El contenido HTML para comenzar el día.
 * */
function BeginDay(dayIndex, weekLevel, date, monthDay) {
    // insertar de las plantillas el string con el contenido html
    // que sirve para empezar un nuevo día
    const monthColorPlaceHolder = "__MONTH_COLOR__";
    const dataBsTargetPlaceHolder = "__WEEK_DAY_TARGET__";
    const weekDayNamePlaceholder = "__NAME__";
    const datePlaceholder = "__DATE__";

    const dateStr = MONTHS[date.getMonth()] + "<br>" + monthDay + "-" + (date.getMonth() + 1) + "-" + date.getFullYear();

    let dayStr = platillas.BEGIN_DAY.replaceAll(dataBsTargetPlaceHolder, "weekDay-" + GetUUID()).
                                        replaceAll(weekDayNamePlaceholder, DAYS_OF_WEEK[dayIndex]).
                                        replaceAll(datePlaceholder, dateStr).
                                        replaceAll(monthColorPlaceHolder, "bg-color-" + (date.getMonth() + 1));

    return dayStr;
}

/**
 * Inserta el contenido HTML para finalizar el último día comenzado.
 * @param {string} dayStr - El contenido HTML del día que se desea finalizar.
 * @param {boolean} tieneEventos - Indica si el día tiene eventos.
 * @returns {string} - El contenido HTML para finalizar el día.
 * */
function EndDay(dayStr, tieneEventos) {
    // insertar de las plantillas el string con el contenido html
    // que sirve para acabar el último día comenzado
    const hasEventsPlaceholder = "__HAS_EVENTS__";

    return dayStr.replaceAll(hasEventsPlaceholder, tieneEventos ? "(Ocupado)" : "(Vacío)") + platillas.END_DAY;
}

/**
 * Crea y devuelve un objeto Date a partir del año, mes y día especificados.
 * @param {number} year - El año.
 * @param {number} month - El mes (0-11).
 * @param {number} day - El día del mes.
 * @returns {Date} - El objeto Date creado.
 * */
function MakeDateFrom(year, month, day) {
    return new Date(year + "-" + month + "-" + day);
}

/**
 * Genera contenido HTML para un día vacío.
 * @param {number} dayIndex - El índice del día de la semana.
 * @param {number} weekLevel - El nivel de la semana.
 * @returns {string} - El contenido HTML para un día vacío.
 * */
function EmptyDay(dayIndex, weekLevel) {
    const dayName = "__DAY__";
    const dayNameCap = "__NAME__";
    const weekLevelTarget = "__WEEK_LEVEL__";

    let emptyDay = platillas.EMPTY_DAY.replaceAll(dayName, DAYS_OF_WEEK[dayIndex].toLowerCase()).
                                        replaceAll(dayNameCap, DAYS_OF_WEEK[dayIndex]).
                                        replaceAll(weekLevelTarget, weekLevel);

    return emptyDay;
}

/**
 * Obtiene una clase CSS basada en el color proporcionado.
 * @param {string} color - El nombre del color (por ejemplo, "green", "yellow").
 * @returns {string} - El nombre de la clase CSS correspondiente.
 * */
function GetCSSEventColor(color) {
    switch (color) {
        case "green": return "event-green";
        case "yellow": return "event-yellow";
        case "red": return "event-red";
        case "orange": return "event-orange";
        case "blue": return "event-blue";
        default:
            console.log("Color inválido");
            break;
    }
}

/**
 * Genera contenido HTML para un evento.
 * @param {string} hora - La hora del evento.
 * @param {string} motivo - La descripción del evento.
 * @param {string} color - El color del evento.
 * @returns {string} - El contenido HTML para el evento.
 * */
function MakeEvent(hora, motivo, color) {
    const horaPlaceHolder = "__TIME__";
    const motivoPlaceholder = "__EVENT_MESSAGE__";
    const colorPlaceholder = "__EVENT_COLOR__";

    let event = platillas.EVENT.replaceAll(horaPlaceHolder, hora).
                                        replaceAll(motivoPlaceholder, motivo).
                                        replaceAll(colorPlaceholder, GetCSSEventColor(color));

    return event;
}

/**
 * Escribe el contenido proporcionado en un archivo de salida.
 * @param {string} filePath - La ruta del archivo de salida.
 * @param {string} contents - El contenido a escribir en el archivo.
 * */
function GenerateOutputFile(filePath, contents) {
    fs.writeFile(filePath, contents, 'utf8', (err) => {
        if (err) {
            console.error(`Error al escribir al fichero. Mensaje: ${err.message}`);
        } 
        else {
            console.log(`Se ha escrito al fichero '${filePath}' correctamente`);
        }
    });
}

/**
 * Genera contenido HTML para días descartados dentro de una semana.
 * @param {string} str - El contenido de la semana actual.
 * @param {number} desde - El índice del día a partir del cual se descartan días.
 * @param {number} hasta - El índice del día hasta el cual se descartan días.
 * @param {number} weekLevel - El nivel de la semana.
 * @returns {Object} - Un objeto con el recuento de días descartados y el contenido de la semana.
 * */
function GetDiasDescartados(str, desde, hasta, weekLevel) {
    let count = desde;
    while (count < hasta && count < WEEK_DAYS_MAX) {
        str += EmptyDay(count, weekLevel);
        ++count;
    }

    // Queremos insertar un domingo descartado
    if (hasta == 8) {
        str += EmptyDay(0, weekLevel);
    }

    return {"count": count, "week": str };
}

/**
 * Inserta contenido HTML para un domingo y gestiona eventos para un día.
 * @param {Object} datos - Un objeto que contiene varios datos y parámetros.
 * */
function InsertarDomingo(datos) {
    let weekStr = datos["weekStr"];
    let listaEventos = datos["listaEventos"];
    let currentDate = datos["currentDate"];
    let OnEventCallback = datos["onEventCallback"];
    let currentYearDay = datos["currentDayOfYear"];
    let eventDate = MakeDate(listaEventos[datos["eventListIndex"]]);

    let dayStr = BeginDay(0, datos["weekLevel"], currentDate, datos["currentDayOfYear"]);        
    let hayAlMenosUnEvento = false;

    let result = OnEventCallback(currentDate, eventDate, dayStr);
    let hayEventos = result["hayEvento"];
    
    while (hayEventos) {
        if (hayEvento) {
            hayAlMenosUnEvento = true;
        }

        dayStr = result["dayStr"];
        
        result = OnEventCallback(currentDate, eventDate, dayStr);
        hayEventos = result["hayEvento"];
    }

    dayStr = EndDay(dayStr, hayAlMenosUnEvento);
    weekStr += dayStr;

    ++currentYearDay;

    datos["weekStr"] = weekStr;
    datos["currentDayOfYear"] = currentYearDay;
}

/**
 * Indica si un año es bisiesto
 * @param anio año a ser evaluado
 * @returns {boolean} cierto si el año es bisiesto, falso en caso contrario
 * */
function EsBisiesto(anio) {
    const IsLastCenturyYear = (year) => year % 100 == 0;

    if (anio >= 1582 && IsLastCenturyYear(anio)) {
        return anio % 400 == 0;
    }
    else {
        return anio % 4 == 0;
    }
}

/**
 * Genera una serie de calanderios por cada año para los eventos
 * contenidos en la lista de eventos que se pasa como parámetro. Guarda
 * en calendarYears una lista con dos elementos por cada calendario generado,
 * el primer elemento de la sublista representa el año del calendario y 
 * el segundo el contenido HTML
 * @param {Array} listaEventos lista conteniendo eventos
 * */
function GenerateCalendars(listaEventos) {
    let terminado = false;  // Indica si queremos seguir tratando más años
    let eventListIndex = 0; // Índice a la lista de eventos
    
    while (!terminado) {
        // Cojemos el primer año, como la lista ya está ordenada, el primer
        // año a tratar es el primero de la lista de eventos
        const currentYear = MakeDate(listaEventos[eventListIndex]).getFullYear();

        if (EsBisiesto(currentYear)) {
            daysPerMonth[1] = 29;
        }
        else {
            daysPerMonth[1] = 28;
        }

        let currentYearStr = BeginYear(currentYear);

        let weekStr = '';           // String con los días de la semana actual
        let weekLevel = 0;          // número de semana 
        let currentYearDay = 1;     // día del año [1, 366]
        let monthCount = 1;         // contador de meses [1, 12]
        
        // lambda que se ejecuta cuando hay un evento
        const OnEvent = (currentDate, dayStr) => {
            if (eventListIndex == listaEventos.length) {
                return { "hayEvento": false, "dayStr": dayStr };
            }

            let eventDate = MakeDate(listaEventos[eventListIndex]);

            if (currentDate.toDateString() === eventDate.toDateString()) {
                // este día de la semana hay evento
                RUN_ON_DEBUG(() => { console.log("Hay evento el: " + currentDate.toDateString()) });
                let str = dayStr + MakeEvent(listaEventos[eventListIndex]["hora"], listaEventos[eventListIndex]["motivo"], listaEventos[eventListIndex]["color"]);
                ++eventListIndex;

                return { "hayEvento": true, "dayStr": str };
            }

            return { "hayEvento": false, "dayStr": dayStr };
        };

        // Primer dia de el año actual
        const firstOf = MakeDateFrom(currentYear, monthCount, 1);

        // Tratar primera semana (en la primera semana pueden haber días del año pasado, los descartamos)
        weekStr = BeginWeek();
        {
            // día actual de la primera semana (los días en nuestro calendario 
            // empiezan el lunes, 1. En JS empiezan el domingo, 0)
            let weekDayIndex = 1;

            let result = GetDiasDescartados(weekStr, 
                                            weekDayIndex, 
                                            firstOf.getDay() == 0 ? WEEK_DAYS_MAX : firstOf.getDay(), // si el año empieza un domingo descartamos los seis primeros días de esa semana
                                            weekLevel);
            
            weekStr = result["week"];
            weekDayIndex = result["count"];

            // gestionamos los días que no están descartados
            while (weekDayIndex < 7) {
                let currentDate = MakeDateFrom(currentYear, monthCount, currentYearDay);
                let dayStr = BeginDay(weekDayIndex, weekLevel, currentDate, currentYearDay);

                // gestionar eventos del día actual de la primera semana
                let hayAlmenosUnevento = false;
                {
                    let result = OnEvent(currentDate, dayStr);
                    let hayEventos = result["hayEvento"];
                    
                    while (hayEventos) {
                        if (hayEventos) {
                            hayAlmenosUnevento = true;
                        }

                        dayStr = result["dayStr"];

                        result = OnEvent(currentDate, dayStr);
                        hayEventos = result["hayEvento"];
                    }
                }
                
                dayStr = EndDay(dayStr, hayAlmenosUnevento);
                                
                weekStr += dayStr;

                ++weekDayIndex;
                ++currentYearDay;
            }
            
            let datos = { 
                "weekStr":          weekStr,
                "weekLevel":        weekLevel,
                "currentDate":      MakeDateFrom(currentYear, monthCount, currentYearDay),
                "listaEventos":     listaEventos,
                "eventListIndex":   eventListIndex,  
                "onEventCallback":  OnEvent,
                "currentDayOfYear": currentYearDay,
            };

            InsertarDomingo(datos);
            
            currentYearDay = datos["currentDayOfYear"];
            weekStr = datos["weekStr"];
        }

        weekStr = EndWeek(weekStr);
        ++weekLevel;

        // añadir la semana a este año
        currentYearStr += weekStr;

        let monthDaysCount = currentYearDay;

        while (currentYearDay < 365) {
            let weekStr = BeginWeek();

            {
                let dayOfTheWeekCount = 1; 

                // controlará si el año se acaba esta semana
                let yearIsFinished = false;

                while (dayOfTheWeekCount < 7 && !yearIsFinished) {
                    let currentDate = MakeDateFrom(currentYear, monthCount, monthDaysCount);

                    let dayStr = BeginDay(dayOfTheWeekCount, weekLevel, currentDate, monthDaysCount);

                    // gestionar eventos de un día
                    let hayAlmenosUnevento = false;
                    {
                        let result = OnEvent(currentDate, dayStr);
                        let hayEventos = result["hayEvento"];
                        
                        while (hayEventos) {
                            if (hayEventos) {
                                hayAlmenosUnevento = true;
                            }

                            dayStr = result["dayStr"];
    
                            result = OnEvent(currentDate, dayStr);
                            hayEventos = result["hayEvento"];
                        }
                    }
                    
                    dayStr = EndDay(dayStr, hayAlmenosUnevento);

                    weekStr += dayStr;
                    
                    ++currentYearDay;
                    ++monthDaysCount;
                    ++dayOfTheWeekCount;

                    if (monthCount == MONTHS_MAX && monthDaysCount > daysPerMonth[monthCount - 1]) {
                        yearIsFinished = true;
                    }

                    // avanzamos mes si hemos llegado al límite del més actual
                    if (monthDaysCount > daysPerMonth[monthCount - 1]) {
                        monthDaysCount = 1;
                        ++monthCount;
                    }
                }

                // Insertar domingo     
                if (!yearIsFinished) {    
                    let currentDate = MakeDateFrom(currentYear, monthCount, monthDaysCount);
                    let dayStr = BeginDay(0, weekLevel, currentDate, monthDaysCount);

                    // gestionar eventos de un día
                    let hayEventos = false;
                    {
                        let result = OnEvent(currentDate, dayStr);
                        hayEventos = result["hayEvento"];
                        
                        while (hayEventos) {
                            dayStr = result["dayStr"];
    
                            result = OnEvent(currentDate, dayStr);
                            hayEventos = result["hayEvento"];
                        }
                    }

                    dayStr = EndDay(dayStr, hayEventos);
    
                    ++currentYearDay;
                    ++monthDaysCount;
    
                    if (monthDaysCount > daysPerMonth[monthCount - 1]) {
                        monthDaysCount = 1;
                        ++monthCount;
    
                    }

                    weekStr += dayStr;
                }     
                else {
                    let result = GetDiasDescartados(weekStr, dayOfTheWeekCount, 8, weekLevel);
                    weekStr = result["week"];
                }       

            }

            weekStr = EndWeek(weekStr);
            ++weekLevel;

            currentYearStr += weekStr;
        }

        currentYearStr = EndYear(currentYearStr);

        calendarYears.push([ currentYear, currentYearStr ]);

        // terminamos cuando no hay más eventos 
        // (por lo tanto, no hay más calendarios que crear)
        if (eventListIndex == listaEventos.length) {
            terminado = true;
        }
    }
}

/**
 * Cargar el contenido de un archivo de forma asíncrona.
 * @param {string} nombreArchivo - El nombre del archivo a cargar.
 * @returns {Promise<string>} Una promesa que resuelve con el contenido del archivo o se rechaza con un error si la carga falla.
 * */
function CargarArchivo(nombreArchivo) {
    return new Promise((resolve, reject) => {
        fs.readFile(nombreArchivo, 'utf8', (error, contenido) => {
            if (error) {
                reject(error);
            } else {
                resolve(contenido);
            }
        });
    });
}

/**
 * Genera archivos HTML de calendario a partir de una lista de enlaces y estilos.
 * @param {Array<string>} listaEnlaces - Lista de enlaces para los calendarios.
 * @param {Array<string>} listaEnlacesFooter - Lista de enlaces para el pie de página.
 * */
function GenerateOutputFilesForCalendars(listaEnlaces, listaEnlacesFooter) {
    const calendarLinksPlaceholder = "__CALENDARS__";
    const bottomLinksNavPlaceHolder = "__BOTTOM_LINKS__";
    const cssContentsPlaceholder = "__STYLES__";
    const jsContentsPlaceholder = "__SCRIPT__";

    // Nombres de los archivos que deseas cargar (se asume que se lanza desde la carpeta src)
    const cssBT = "src/cdn.jsdelivr.net_npm_bootstrap@5.3.2_dist_css_bootstrap.min.css";
    const jsBT = "src/cdn.jsdelivr.net_npm_bootstrap@5.3.2_dist_js_bootstrap.bundle.min.js";
    const css = "src/styles.css";

    // Cargar los archivos de forma asíncrona
    // Cuando se hayan cargado todos, procedemos a la creación de los archivos HTML
    // Los ficheros de estilo son imprescindibles para la creación de los calendarios
    Promise.all([CargarArchivo(cssBT), CargarArchivo(jsBT), CargarArchivo(css)])
        .then(resultados => {
            const contenidocssBT = resultados[0];
            const contenidojsBT = resultados[1];
            const contenidocss = resultados[2];

            let index = 0;
            for (let year of calendarYears) {
                GenerateOutputFile(outputDirectory + "calendario-" + year[0] + ".html",
                    year[1].
                        replaceAll(jsContentsPlaceholder, contenidojsBT).
                        replaceAll(cssContentsPlaceholder, contenidocssBT + "\n" + contenidocss).
                        replaceAll(calendarLinksPlaceholder, listaEnlaces).
                        replaceAll(bottomLinksNavPlaceHolder, listaEnlacesFooter[index++]));
            }
        })
        .catch(error => {
            console.error("Error al cargar los archivos:", error);
    });
}


/**
 * Entrada principal de ejecución. Valida los argumentos de entrada por consola,
 * en caso de ser válidos, genera los calendarios necesarios
 * */
function Run() {
    const wantProgress = ParseCmdLineArguments();

    if (wantProgress) {
        // validar directorio de salida y fichero de datos
        if (!(IsValidDirectory(outputDirectory) && IsValidFile(dataFilePath))) {
            RUN_ON_DEBUG(() => { console.log("Se requiere un directorio de salida válido y un fichero JSON con los eventos válido" )} );
            return;
        }
        
        fs.readFile(dataFilePath, "utf8", (err, data) => {
            if (err) {
                console.error(`Error al leer el fichero: ${err.message}`);
            }
            else {
                let listaEventos = GetParsedJSONData(data);

                listaEventos.sort((lhs, rhs) => MakeDate(lhs) - MakeDate(rhs));

                RUN_ON_DEBUG(
                    () => {
                        console.log("Mostrando lista de eventos ordenada ---------------------------");
                        for (let index = 0; index < listaEventos.length; ++index) {
                            console.log(listaEventos[index]);
                        }
            
                        console.log("Finalizando muestra lista de eventos ordenada -----------------\n");
                    }
                );
                RUN_ON_DEBUG(() => { console.log("Generando calendarios en ruta " + outputDirectory) });
                GenerateCalendars(listaEventos);

                // generar enlaces
                let listaEnlaces = "";

                const linkPlaceholder = "__LINK__";
                const yearPlaceholder = "__YEAR__";

                
                for (let year of calendarYears) {
                    // los enlaces son relativos al directorio actual
                    const filePath = 'calendario-' + year[0] + ".html";
                    listaEnlaces += platillas.LINK.replaceAll(linkPlaceholder, filePath).
                                                    replaceAll(yearPlaceholder, year[0]);
                }
                
                const bottomLinkPlaceHolder = "__LINK__";
                const bottomLinkYearPlaceholder = "__YEAR__";
                const disableButtonPrevPlaceholder = "__DISABLE_PREV__";
                const disableButtonNextPlaceholder = "__DISABLE_NEXT__";

                let listaEnlacesFooter = []

                for (let year of calendarYears) {
                    // los enlaces son relativos al directorio actual
                    
                    let footerLinks = ""
                    
                    for (let yearCurrent of calendarYears) {
                        const filePath = 'calendario-' + yearCurrent[0] + ".html";
                        if (yearCurrent[0] != year[0]) {
                            footerLinks += platillas.BOTTOM_LINK.replaceAll(bottomLinkPlaceHolder, filePath).
                                                        replaceAll(bottomLinkYearPlaceholder, yearCurrent[0]);
                        }
                        else {
                            footerLinks += platillas.BOTTOM_LINK_ACTIVE.replaceAll(bottomLinkPlaceHolder, filePath).
                                                        replaceAll(bottomLinkYearPlaceholder, yearCurrent[0]);
                        }
                    }

                    listaEnlacesFooter.push(footerLinks);

                }

                const bottomLinksPrevPlaceholder = "__LINK_PREV__";
                const bottomLinksNextPlaceholder = "__LINK_NEXT__";

                // generar navegación del footer
                for (let index = 0; index < calendarYears.length; ++index) {
                    // anterior 
                    if (index - 1 < 0) {
                        calendarYears[index][1] = calendarYears[index][1].replaceAll(disableButtonPrevPlaceholder, " disabled");
                        calendarYears[index][1] = calendarYears[index][1].replaceAll(bottomLinksPrevPlaceholder, "#");
                    }
                    else {
                        calendarYears[index][1] = calendarYears[index][1].replaceAll(disableButtonPrevPlaceholder, "");
                        calendarYears[index][1] = calendarYears[index][1].replaceAll(bottomLinksPrevPlaceholder, 'calendario-' + calendarYears[index - 1][0] + ".html");
                    }

                    // posterior
                    if (index + 1 == calendarYears.length) {
                        calendarYears[index][1] = calendarYears[index][1].replaceAll(disableButtonNextPlaceholder, " disabled");
                        calendarYears[index][1] = calendarYears[index][1].replaceAll(bottomLinksNextPlaceholder, "#");
                    }
                    else {
                        calendarYears[index][1] = calendarYears[index][1].replaceAll(disableButtonNextPlaceholder, "");
                        calendarYears[index][1] = calendarYears[index][1].replaceAll(bottomLinksNextPlaceholder, 'calendario-' + calendarYears[index + 1][0] + ".html");
                    }
                }

                // hacemos la lectura y escritura
                GenerateOutputFilesForCalendars(listaEnlaces, listaEnlacesFooter);
            

                RUN_ON_DEBUG(
                    () => {
                        console.log("\nCalendario generado para los años:\n")
                        for (year of calendarYears) {
                            console.log("Año: " + year[0]);

                        }

                        // salto de línea
                        console.log();
                    }
                );
            }
        });
    }
}

Run()