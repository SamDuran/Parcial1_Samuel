package edu.ucne.parcial1_samuel.ui.entity

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun entityScreen(
    onSave: () -> Unit,
    viewModel: entityViewModel = hiltViewModel()
) {
    Button(onClick = {
        viewModel.save()
        onSave()
    }) {
        Text("Save")
    }
}