package edu.ucne.parcial1_samuel.ui.entity

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


data class entityListUiState(
    val list: List<Boolean> = emptyList()
)
@HiltViewModel
class entityListViewModel @Inject constructor(

) : ViewModel() {
    var uiState by mutableStateOf(entityListUiState())
    private set

    init {
        viewModelScope.launch {
            //llamar al repository.GetList
        }
    }
}