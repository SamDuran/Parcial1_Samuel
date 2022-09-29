package edu.ucne.parcial1_samuel.ui.articulo

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ArticuloScreen(
    id: Int = 0,
    onSave: () -> Unit,
    viewModel: ArticuloViewModel = hiltViewModel()
) {

    remember(id){
        viewModel.findById(id)
        0
    }
    var existenciaError: String? = null
    var marcaError: String? = null
    var descripcionError: String? = null


    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Registro de Articulos") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                if(descripcionError == null
                    && marcaError == null
                    && existenciaError == null)
                {
                    viewModel.save()
                    onSave()
                }
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    ) {
        val modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)

        Column(
            modifier = modifier
        ) {


            OutlinedTextField(
                value = viewModel.uiState.descripcion,
                label = {Text("Descripcion")},
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Sentences
                ),
                modifier = modifier,
                onValueChange = {
                    viewModel.setDescripcion(it)
                    descripcionError = getDescripcionError(viewModel.uiState.descripcion)
                },
                isError = descripcionError != null
            )
            if(descripcionError!=null) Text(text = descripcionError!!, color = Color.Red)


            OutlinedTextField(
                value = viewModel.uiState.marca,
                label = {Text("Marca")},
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Sentences
                ),
                modifier = modifier,
                onValueChange = {
                    viewModel.setMarca(it)
                    marcaError = getMarcaError(viewModel.uiState.marca)
                },
                isError = marcaError != null
            )
            if(marcaError!=null) Text(text = marcaError!!,color = Color.Red)



            OutlinedTextField(
                value = viewModel.uiState.existencia,
                label = {Text("Existencia")},
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Decimal,
                ),
                modifier = modifier,
                onValueChange = {
                    viewModel.setExistencia(it)
                    existenciaError =
                        getExistenciaError((viewModel.uiState.existencia.toDoubleOrNull()) ?: -1.0)
                },
                isError = existenciaError != null
            )
            if(existenciaError!= null) Text(text =existenciaError!!, color = Color.Red)


        }
    }
}

private fun getDescripcionError(descripcion: String): String? {
    return if (descripcion.isBlank()|| descripcion.length<2) "*Ingrese una descripción valida*" else null
}

private fun getMarcaError(marca: String): String? {
    return if (marca.isBlank()) "*Ingrese una marca valida*" else null
}

private fun getExistenciaError(existencia: Double): String? {
    return if (existencia >= 0) "*Ingrese una existencia valida*" else null
}