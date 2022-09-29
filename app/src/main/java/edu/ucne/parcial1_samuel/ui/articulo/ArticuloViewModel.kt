package edu.ucne.parcial1_samuel.ui.articulo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.parcial1_samuel.data.local.entities.Articulo
import edu.ucne.parcial1_samuel.data.repository.ArticuloRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ArticuloUiState(
    val id: Int = 0,
    val descripcion : String = "",
    val marca : String = "",
    val existencia : String = ""
)

@HiltViewModel
class ArticuloViewModel @Inject constructor(
    private val repository : ArticuloRepository
) : ViewModel() {
    var uiState by mutableStateOf(ArticuloUiState())
    private set


    fun save() {
        viewModelScope.launch {
            repository.insert(
                Articulo(
                    articuloId = uiState.id,
                    descripcion = uiState.descripcion,
                    marca = uiState.marca,
                    existencia = uiState.existencia.toDouble()
                )
            )
        }
    }
    fun findById(id:Int) {
        viewModelScope.launch {
            repository.findById(id)?.let {
                uiState = uiState.copy(
                    id = it.articuloId,
                    descripcion =  it.descripcion,
                    marca = it.marca,
                    existencia = it.existencia.toString()
                )
            }
        }
    }

    fun setDescripcion(newValue: String) {
        uiState = uiState.copy(descripcion = newValue)
    }

    fun setMarca(it: String) {
        uiState = uiState.copy(marca = it)
    }

    fun setExistencia(it: String) {
        uiState = uiState.copy(existencia = it)
    }

}