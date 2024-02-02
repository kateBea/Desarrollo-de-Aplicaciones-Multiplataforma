package edu.villablanca.demosensores.ui.pantallas

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.lang.reflect.Modifier

/**
 *  Utilizando el sensor de presencia
 */
@Composable
fun PantallaPresencia() {

    val contexto = LocalContext.current
    val sensorStatus = remember { mutableStateOf("Desconocido") }

    // Gestionar el ciclo de vida del sensor con DisposableEffect
    DisposableEffect(contexto) {
        val sensorManager = contexto.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)
        val proximitySensorEventListener = getProximitySensorEventListener(sensorStatus)

        sensorManager.registerListener(proximitySensorEventListener, proximitySensor, SensorManager.SENSOR_DELAY_NORMAL)

        // Al limpiar, desregistrar el listener
        onDispose {
            sensorManager.unregisterListener(proximitySensorEventListener)
        }
    }

    /**
     * Parte gráfica
     */


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Object is",
            // on below line we are setting text color
            color = Color.Black,

            // on below line we are specifying font weight
            fontWeight = FontWeight.Bold,

            // on below line we are specifying font family.
            fontFamily = FontFamily.Default,

            // on below line we are specifying
            // font size and padding from all sides.
            fontSize = 40.sp,
        )

        Text(
            text = sensorStatus.value,
            // on below line we are setting color for our text
            color = Color.Black,

            // on below line we are setting font weight as bold
            fontWeight = FontWeight.Bold,

            // on below line we are setting font family
            fontFamily = FontFamily.Default,

            // on below line we are setting font family and padding
            fontSize = 40.sp,
        )
        // on below line we are creating a text for displaying a sensor.
        Text(
            text = "Sensor",
            // on below line we are displaying a text color
            color = Color.Black,

            // on below line we are setting font weight
            fontWeight = FontWeight.Bold,

            // on below line we are setting font family
            fontFamily = FontFamily.Default,

            // on below line we are setting font size and padding.
            fontSize = 40.sp,
        )
    }
}


fun getProximitySensorEventListener(sensorStatus: MutableState<String>): SensorEventListener = object : SensorEventListener {
    override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
        // Opcional: manejar cambios de precisión.
    }

    override fun onSensorChanged(event: SensorEvent) {
        if (event.sensor.type == Sensor.TYPE_PROXIMITY) {
            sensorStatus.value = if (event.values[0] == 0f) "Near" else "Away"
        }
    }
}