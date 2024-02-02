package edu.villablanca.ut8.servicios


import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class ServicioLog : Service() {

    companion object {
        private const val TAG = "ServicioLog"
    }

    override fun onCreate() {
        super.onCreate()
        Log.i(TAG, "Service onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i(TAG, "Servicio onStartCommand")

        // Ejecutar una tarea en segundo plano
        Thread {
            try {
                for (i in 0 until 5) {
                    Thread.sleep(5000)
                    Log.i(TAG, "Servicio ejecutando ($i)")
                }
            } catch (e: InterruptedException) {
                Thread.currentThread().interrupt()
            }
        }.start()

        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        // Este es un Started Service, no un Bound Service, así que devuelve null.
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "Servicio onDestroy")
    }
}
