const { app, BrowserWindow } = require("electron");

let window = null;

function createWindow() {
    window = new BrowserWindow({
        width: 840,
        height: 720,
        webPreferences: {
            nodeIntegration: true
        }
    });

    window.loadFile("src/index.html");
    
    window.on("closed", () => {
        window = null;
    });
}

app.on("ready", createWindow);