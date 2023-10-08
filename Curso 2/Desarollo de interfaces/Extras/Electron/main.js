const { app, BrowserWindow } = require("electron");

let window = null;

function createWindow() {
    window = new BrowserWindow({
        width: 530,
        height: 630,
        webPreferences: {
            nodeIntegration: true
        }
    });

    window.loadFile("index.html");
    
    window.on("closed", () => {
        window = null;
    });
}

app.on("ready", createWindow);