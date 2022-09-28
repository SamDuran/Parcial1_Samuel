package edu.ucne.parcial1_samuel.ui.articulo

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ArticuloScreen(
    onSave: () -> Unit,
    viewModel: ArticuloViewModel = hiltViewModel()
) {
    Button(onClick = {
        viewModel.save()
        onSave()
    }) {
        Text("Save")
    }
}