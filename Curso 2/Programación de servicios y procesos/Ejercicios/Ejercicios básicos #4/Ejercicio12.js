const fs = require('fs');

const filePath = 'datos.txt';
const dataToWrite = 'Hola mundo';

async function writeToFileAsync(filePath, data) {
    try {
        await fs.promises.writeFile(filePath, data);
        console.log('Escritura exitosa.');
    } catch (error) {
        console.error('Error al escribir al fichero:', error);
    }
}

async function readFromFileAsync(filePath) {
    try {
        const readFileResult = await fs.promises.readFile(filePath, 'utf8');
        console.log('Contenido:', readFileResult);
    } catch (error) {
        console.error('Error al leer fichero: ', error);
    }
}

writeToFileAsync(filePath, dataToWrite)
    .then(() => {
        return readFromFileAsync(filePath);
    })
    .catch(error => console.error('Error:', error));