package edu.villablanca.ut4.vm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.villablanca.ut4.vm.modelo.FrutasVM
import edu.villablanca.ut4.vm.modelo.SensorVM
import edu.villablanca.ut4.vm.ui.theme.UT4Theme

class VMActivity : ComponentActivity() {
    //
    //creamos una instancia FrutasVM para que sea gestionada por delegacion
    // con viewModels
    
    private val miModelo by viewModels<FrutasVM> ()
    private val modeloSensor by viewModels<SensorVM> ()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        modeloSensor.empezar()

        setContent {
            UT4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                PantallaVM(vm = miModelo, sensor= modeloSensor)
                }
            }
        }
    }
}

class PantallaVM(vm: FrutasVM, sensor: SensorVM) {

}


@Preview(showBackground = true)
@Composable
private fun VMPreview2() {
    UT4Theme {
      //PantallaVM()
    }
}