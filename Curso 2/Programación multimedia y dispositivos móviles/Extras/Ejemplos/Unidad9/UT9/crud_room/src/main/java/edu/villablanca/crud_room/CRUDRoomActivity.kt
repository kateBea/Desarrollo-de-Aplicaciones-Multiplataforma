package edu.villablanca.crud_room

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import edu.villablanca.crud_room.data.BaseDatos
import edu.villablanca.crud_room.ui.theme.UT9Theme
import edu.villablanca.crud_room.ui.navegacion.NavUsuario
import edu.villablanca.crud_room.viewmodel.UsuarioViewModel

/**
 * Creamos la base de datos , ViewModel y dao de usuario
 * La base de datos se puede crear también a nivel de aplicación
 *
 * Se llama al @Composable de navegació
 */
class CRUDRoomActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = Room.databaseBuilder(this, BaseDatos::class.java, "usuarios_db")
            .fallbackToDestructiveMigration()  // migra el esquema de  version borrando
            .build()
        val dao = database.usuarioDao()
       // val tareaDao = database.tareaDao()
        val usuarioVM = UsuarioViewModel(dao)

        setContent {
            UT9Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavUsuario(usuarioViewModel = usuarioVM)
                }
            }
        }
    }
}
