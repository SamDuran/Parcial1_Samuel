package edu.ucne.parcial1_samuel.ui.articulo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.parcial1_samuel.data.local.entities.Articulo
import edu.ucne.parcial1_samuel.data.repository.ArticuloRepository
import kotlinx.coroutines.launch
import javax.inject.Inject


data class ArticuloListUiState(
    val articulos: List<Articulo> = emptyList()
)
@HiltViewModel
class ArticuloListViewModel @Inject constructor(
    private val repository: ArticuloRepository
) : ViewModel() {
    var uiState by mutableStateOf(ArticuloListUiState())
    private set

    init {
        viewModelScope.launch {
            repository.getArticulos().collect() {
                uiState = uiState.copy(articulos = it)
            }
        }
    }
}