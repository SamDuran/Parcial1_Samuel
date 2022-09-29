package edu.ucne.parcial1_samuel.ui.articulo

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import edu.ucne.parcial1_samuel.data.local.entities.Articulo

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ArticuloListScreen(
    newEntityClick: () -> Unit,
    viewModel: ArticuloListViewModel = hiltViewModel(),
    onItemClick: (Int) -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Articulos") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = newEntityClick) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            }
        }
    ) {
        val lista = viewModel.uiState.articulos
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            lista.forEach{
                item{
                    ArticuloRow(articulo = it, onArticuloClick = onItemClick)
                }
            }
        }
    }
}

@Composable
fun ArticuloRow(articulo: Articulo, onArticuloClick: (Int)->Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .clickable{onArticuloClick(articulo.articuloId)}
    ){
        Text(
            text=articulo.descripcion,
            style = MaterialTheme.typography.h5,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 5.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Marca: ${articulo.marca}",
                modifier = Modifier.padding(horizontal = 5.dp)
            )

            Text(
                text ="Existencia: ${articulo.existencia}" ,
                modifier = Modifier.padding(horizontal = 5.dp)
            )
        }
    }
}