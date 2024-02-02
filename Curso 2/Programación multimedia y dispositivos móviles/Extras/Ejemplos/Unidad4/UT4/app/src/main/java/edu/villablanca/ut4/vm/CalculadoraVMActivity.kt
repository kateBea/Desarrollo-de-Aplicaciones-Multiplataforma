package edu.villablanca.ut4.vm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import edu.villablanca.ut4.ui.theme.UT4Theme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CalculadoraVMActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UT4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PantallaCalculadoraVM()
                }
            }
        }
    }
}



data class UiState(
    val op1: String ="",
    val op2: String ="",
    val resultado: String ="",

)


class CalculadoraVM: ViewModel(){
    private val _uistate = MutableStateFlow( UiState())
    val uiState: StateFlow<UiState> = _uistate.asStateFlow()

    private fun calcular(){
        val v1 = _uistate.value.op1.toIntOrNull() ?:0
        val v2 = _uistate.value.op2.toIntOrNull() ?:0
        if( v1 != 0 && v2 != 0) {
            _uistate.update {
                it.copy(resultado = (v1 + v2).toString())
            }
        }
    }
    fun setOp1(op: String){
        _uistate.update { it.copy(op1=op) }
        calcular()
    }
    fun setOp2(op: String){
        _uistate.update { it.copy(op2=op) }
        calcular()
    }
}

@Composable
fun CalculadoraVM(vm: CalculadoraVM) {
    val uiEstado = vm.uiState.collectAsState()

    Column {

        TextField(value = uiEstado.value.op1 , onValueChange = {
            if( it =="")
                vm.setOp1("")
            else if(it.toIntOrNull() != null)
                 vm.setOp1(it)
        })
        TextField(value = uiEstado.value.op2 , onValueChange = {
            if( it !="")
                if(it.toIntOrNull() != null)
                  vm.setOp2(it)})
        Text(text = uiEstado.value.resultado)
    }
}


@Composable
fun PantallaCalculadoraVM() {
    val vm = viewModel(initializer = { CalculadoraVM() } )

    CalculadoraVM(vm = vm)
}