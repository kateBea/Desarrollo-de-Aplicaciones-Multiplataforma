// Ids - Lista de IDs de los elementos HTML
const ID_NOMBRE     = "nombre";
const ID_APELLIDOS  = "apellidos";
const ID_EMAIL      = "correo-electronico";
const ID_DIRRECCION = "direccion";

const ID_SELECCION_GM = "cfgm";
const ID_SELECCION_GS = "cfgs";

const ID_GRADO_MEDIO    = "grado-medio";
const ID_GRADO_SUPERIOR = "grado-medio";

const ID_LOGO = "logo-iesv";

// Constantes
const VALOR_SELECCION_GS = "Grado Superior";
const VALOR_SELECCION_GM = "Grado Medio";

const NIVEL_POR_DEFECTO = VALOR_SELECCION_GS;
const MODULO_POR_DEFECTO = "Desarrollo de Aplicaciones Multiplataforma";

const PIXEL_PER_MM = 0.264583;

// Datos - Datos rellenos del formulario
let nombre      = "";
let apellidos   = "";
let email       = "";
let direccion   = "";
let cfgNivel    = "";
let cfgModulo   = MODULO_POR_DEFECTO;

/**
 * Devuelve un string representando el Nivel de ciclo escogido (Grado Superior o Grado Medio)
 * @return string representando el nivel escogido
 * */
function getGradoSeleccionado() {
    if (document.getElementById(ID_SELECCION_GM).hidden == false) {
        return VALOR_SELECCION_GM;
    }

    // solo consideramos a parte de GM, GS por ahora
    return VALOR_SELECCION_GS;
}

/**
 * Guarda el modulo escogido de las lista de módulos desplegables
 * */
function saveCicloModulo(modulo) {
    console.log(modulo);
    cfgModulo = modulo;
}

/**
 * Selecciona el módulo actual
 * */
function guardarModuloSeleccionado() {
    const dam = document.getElementById("grado-dam");
    const daw = document.getElementById("grado-daw");
    const asir = document.getElementById("grado-asir");
    const smr = document.getElementById("grado-smr");

    let found = false;
    let index = 0;

    let elementos = [dam, daw, asir, smr];
    
    while (index < elementos.length && !found) {
        console.log("modulo actual: " + elementos[asir])
        
        if (elementos[index] != null) {
            found = elementos[index].selected == true;
            cfgModulo = elementos[index].value;
        }

        ++index;
    }
}

/**
 * Retorna cierto si todos los elementos de un indexable 
 * cumplen un predicado, falso en caso contrario
 * @returns cierto si todos los elementos de un conjunto cumplen un predicado
 * */
function allMatch(lista, predicate) {
    for (let index = 0; index < lista.length; ++index) {
        if (!predicate(lista[index])) {
            return false;
        }
    }

    return true;
}

/**
 * Recoge los datos actualmente en los capos del formulario,
 * si todos están rellenos retorna cierto, falso en cualquier otro caso.
 * */
function gestionarDatos() {
    nombre = document.getElementById(ID_NOMBRE).value.trim();
    apellidos = document.getElementById(ID_APELLIDOS).value.trim();
    email = document.getElementById(ID_EMAIL).value.trim();
    direccion = document.getElementById(ID_DIRRECCION).value.trim();
    cfgNivel = getGradoSeleccionado();

    // Debug section
    console.log("Nombre del alumno: " + nombre);
    console.log("Apellidos del alumno: " + apellidos);
    console.log("Email del alumno: " + email);
    console.log("Dirreción del alumno: " + direccion);
    console.log("Nivel del ciclo: " + cfgNivel);
    console.log("Módulo del ciclo: " + cfgNivel);


    // cierto si todos los campos tienen datos
    let res = allMatch([nombre, apellidos, email, direccion], 
        (value) => { return value != ""; });

    console.log("Todos están rellenos: " + (res ? "sí" : "no"));
    return res;
}

/**
 * Serializa los datos del formulario a un fichero PDF si todos son válidos,
 * en caso contrario esta operación no tiene efectos.
 * */
function generarPDF() {
    if (!gestionarDatos()) {
        alert("Debe rellenar todos los campos");
        return;
    }

    guardarModuloSeleccionado();

    const logo = document.getElementById(ID_LOGO);

    const doc = new jsPDF({ 
        orientation: "p",
        unit: "mm",
        format: "a4"
    });
    
    doc.text("Formulario de inscripción", 14, 14);
    doc.addImage(logo, "PNG", 210 - 48 * PIXEL_PER_MM - 16, 3, 55 * PIXEL_PER_MM, 42 * PIXEL_PER_MM);

    doc.line(14, 17, 196, 17);

    doc.autoTable({ html: '#tabla' });

    doc.autoTable({
        theme: "grid",
        head: [['Campo', 'Valor']],
        body: [
            ['Nombre', nombre],
            ['Apellidos', apellidos],
            ['Email', email],
            ['Dirección', direccion],
            ['Ciclo', cfgNivel],
            ['Módulo', cfgModulo],
        ],
    });
    
    doc.save("Matrícula.pdf");
}

/**
 * Devuelve los campos del formulario html a sus valores por defecto
 * */
function resetearCampos() {
    nombre = "";
    apellidos = "";
    email = "";
    direccion = "";
    cfgNivel = "";
    cfgModulo = MODULO_POR_DEFECTO;

    document.getElementById(ID_NOMBRE).value = "";
    document.getElementById(ID_APELLIDOS).value = "";
    document.getElementById(ID_EMAIL).value = "";
    document.getElementById(ID_DIRRECCION).value = "";

    document.getElementById(ID_SELECCION_GM).hidden = true;
    document.getElementById(ID_SELECCION_GS).hidden = false;    
}

/**
 * Cambia el desplegable del formulario al conjunto de ciclos
 * formativos de grado superior o medio acorde a la selección de nivel actual
 * @param grado string representando el nivel seleccionado
 * */
function seleccionGrado(grado) {
    if (grado == VALOR_SELECCION_GM) {
        document.getElementById(ID_SELECCION_GM).hidden = false;
        document.getElementById(ID_SELECCION_GS).hidden = true;

        cfgNivel = VALOR_SELECCION_GM;
    }

    if (grado == VALOR_SELECCION_GS) {
        document.getElementById(ID_SELECCION_GS).hidden = false;
        document.getElementById(ID_SELECCION_GM).hidden = true;

        cfgNivel = VALOR_SELECCION_GS;
    }
}