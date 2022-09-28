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
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ArticuloScreen(
    onSave: () -> Unit,
    viewModel: ArticuloViewModel = hiltViewModel(),
) {
    var canSave by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Registro de Articulos") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                if(canSave)
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

            var descripcionError: String? = null
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
            descripcionError?.let { Text(text = it, color = MaterialTheme.colors.onError) }

            var marcaError: String? = null
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
            marcaError?.let { Text(text = it, color = MaterialTheme.colors.onError) }


            var existenciaError: String? = null
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
            existenciaError?.let { Text(text = it, color = MaterialTheme.colors.onError) }

            canSave = descripcionError == null
                    && marcaError == null
                    && existenciaError == null
        }
    }
}

private fun getDescripcionError(descripcion: String): String? {
    return if (descripcion.isBlank()) "*Ingrese una descripción valida*" else null
}

private fun getMarcaError(marca: String): String? {
    return if (marca.isBlank()) "*Ingrese una marca valida*" else null
}

private fun getExistenciaError(existencia: Double): String? {
    return if (existencia >= 0) "*Ingrese una existencia valida*" else null
}