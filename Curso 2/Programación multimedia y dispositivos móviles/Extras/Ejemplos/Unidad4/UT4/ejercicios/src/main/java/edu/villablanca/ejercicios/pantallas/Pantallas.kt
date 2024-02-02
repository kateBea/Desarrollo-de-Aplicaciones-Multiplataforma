package edu.villablanca.ejercicios.pantallas

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import edu.villablanca.ejercicios.PizaActivity
import edu.villablanca.ejercicios.comun.DialogoError
import edu.villablanca.ejercicios.ui.theme.UT4Theme
import edu.villablanca.ejercicios.viewmodel.LoginViewModel

private val PRINCIPAL= "PRINCIPAL"
enum class PANTALLA{
    LOGIN,
    REGISTRO,
    APLICACION,
    DIALOGO_ERROR,
}


@Composable
fun PantallaAplicacion(onBack: (PANTALLA) -> Unit ={}){

    Column {
        TextButton(onClick = { onBack(PANTALLA.LOGIN) }) {
            Text(text = "volver SIN MAS")
        }
        TextButton(onClick = { onBack(PANTALLA.DIALOGO_ERROR) }) {
            Text(text = "Prueba dialogo erro+r")
        }
        Text(text = "Esta seria la pantalla de la app después del login")
    }

}

/**
 *
 *
 *
 *  Añadimos argumento para tener el contexto   de Activity que permite ininicar la
 *  nueva Activity
 */
    @Composable
    fun Pantallas(
        contexto: Context,
        loginVM: LoginViewModel
    ) {
        var pantalla by remember { mutableStateOf(PANTALLA.LOGIN) }
        var pantallaConError by remember {
            mutableStateOf(PANTALLA.LOGIN)
        }



        when(pantalla){
            PANTALLA.LOGIN -> PantallaLogin(
                loginVM,
                onLogin = {
                    Log.d(PRINCIPAL, "login correcto ANTES")

                    loginVM.usuarioValido()  // comprueba nombre y clave
                    if (loginVM.uistate.value.usuarioAutenticado) {
                       // pantalla = PANTALLA.APLICACION
                        // Cambiado por activity de pizza
                        val intencion = Intent(contexto, PizaActivity::class.java).apply{
                            putExtra("nombre", loginVM.uistate.value.nombre)
                            putExtra("telefono",loginVM.uistate.value.telefono)
                        }
                        contexto.startActivity(intencion)
                    } else
                        pantalla = PANTALLA.DIALOGO_ERROR
                },
                onRegistrar = { pantalla = PANTALLA.REGISTRO },
            )
            PANTALLA.REGISTRO -> PantallaRegistro(
                loginVM,
                onRegistrar =  {
                    loginVM.nuevoUsuario()
                    pantalla = PANTALLA.LOGIN
                    //pantalla = PANTALLA.APLICACION
                })
            PANTALLA.APLICACION -> PantallaAplicacion {
                pantalla = it
                pantallaConError = PANTALLA.APLICACION
                println("Se ha devuelto $it")
            }
            else ->{}

        }// del when

       if(pantalla == PANTALLA.DIALOGO_ERROR ) {
       // if(loginVM.uistate.value.usuarioAutenticado)

            DialogoError(
                mensaje = "Error de prueba",
                onDismiss = {
                    loginVM.resetLogin()
                    pantalla = pantallaConError })
        }
    }

@Preview(showBackground = true,
    widthDp = 400,
    heightDp = 800,
    device= "id:pixel_5")
@Composable
fun VistaPrevia() {
    UT4Theme {
       // Pantallas(LoginViewModel())
    }
}