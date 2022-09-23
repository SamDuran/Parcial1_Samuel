package edu.ucne.parcial1_samuel.ui.entity

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun entityListScreen(
    newEntityClick: () -> Unit,
    viewModel: entityListViewModel = hiltViewModel(),
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("entities") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            }
        }
    ) {
        //val lista = viewModel.entity.collectAsState()
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            /*items(lista.value) { entity ->
                EntityRow(entity)
            }*/
        }
    }
}

//@Composable
//fun entityRow(entity : Entity) {
//    Column(
//        modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp)
//    ){
//        Text(
//            text=entity.campo1,
//            style = MaterialTheme.typography.h5,
//            modifier = Modifier.padding(horizontal = 5.dp)
//        )
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Text(
//                text = entity.campo2,
//                modifier = Modifier.padding(horizontal = 5.dp)
//            )
//            Text(
//                text = entity.campo3,
//                modifier = Modifier.padding(horizontal = 5.dp)
//            )
//        }
//    }
//}