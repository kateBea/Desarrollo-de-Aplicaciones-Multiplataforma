package edu.villablanca.ut4.vm

/**
 * MainActivity
 *
 * @dependencias:    implementation("androidx.navigation:navigation-compose:2.7.5")
 */
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat.startActivity
import edu.villablanca.ut4.navi.ui.navegacion.NavGraph
import edu.villablanca.ut4.navi.ui.theme.UT4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UT4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //NavGraph()
                    PantallaIncial(contexto = this)
                }
            }
        }
    }
}

@Composable
fun PantallaIncial(contexto: Context){


    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Demostración de uso de ViewModel")
        Button(onClick = {
            val intentCalculadora = Intent(contexto,CalculadoraActivity::class.java )
            startActivity(contexto, intentCalculadora,null)
        }) {
            Text(text = "Calculadora Estados")
        }
        Button(onClick = {
            val intentCalculadoraVM = Intent(contexto,CalculadoraVMActivity::class.java )
            startActivity(contexto, intentCalculadoraVM,null)
        }) {
            Text(text = "Calculadora ViewModel")
        }
        Button(onClick = {
            val intentFruta = Intent(contexto, VMActivity::class.java)
            startActivity(contexto, intentFruta,null)
        }) {
            Text(text = "Lista Fruta y Temperatura")
        }
        Divider()
        Text(text = "Demostración de Navigation ")
        Button(onClick = {
            val intentNavegacion = Intent(contexto, NavegacionActivity::class.java)
            startActivity(contexto, intentNavegacion,null)
        }) {
            Text(text = "Navagación")
        }

    }
}
