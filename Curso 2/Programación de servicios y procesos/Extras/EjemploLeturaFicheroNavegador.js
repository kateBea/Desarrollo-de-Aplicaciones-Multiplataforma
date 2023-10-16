/**
 * Cargamos los datos del fichero JSON del disco
 * @param fichero ruta del fichero a cargar
 * @returns datos del fichero leído
 * */
function fetchContents(fichero) {
    let contenido = "";

    fetch(fichero)
    .then(response => {
        if (!response.ok) {
            throw new Error('Error de respuesta');
        }
        return response.text();
    })
    .then(data => {
        contenido = data; 

        // Para depuración
        console.log('File contents:', data);
    })
    .catch(error => console.error('Error:', error));

    return contenido;
} 

const datosFichero = fetchContents("ruta");