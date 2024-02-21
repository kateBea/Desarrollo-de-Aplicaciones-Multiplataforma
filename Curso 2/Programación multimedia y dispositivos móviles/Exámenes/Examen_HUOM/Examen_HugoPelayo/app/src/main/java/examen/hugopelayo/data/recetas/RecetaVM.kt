package examen.hugopelayo.data.recetas

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RecetaVM : ViewModel() {

    private val _receta = MutableStateFlow(RecetaState())
    var receta: StateFlow<RecetaState?> = _receta

    fun setRecetaActual(item: Receta) = viewModelScope.launch {
        receta.value?.recetaActual = item
    }
}