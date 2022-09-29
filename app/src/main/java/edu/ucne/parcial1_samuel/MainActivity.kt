package edu.ucne.parcial1_samuel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import edu.ucne.parcial1_samuel.ui.ScreensController
import edu.ucne.parcial1_samuel.ui.articulo.ArticuloListScreen
import edu.ucne.parcial1_samuel.ui.articulo.ArticuloScreen
import edu.ucne.parcial1_samuel.ui.theme.Parcial1_SamuelTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Parcial1_SamuelTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = ScreensController.ArticuloListScreen.route
                ) {
                    composable(ScreensController.ArticuloListScreen.route) {
                        ArticuloListScreen(
                            newEntityClick = {
                                navController.navigate(
                                    ScreensController.ArticuloScreen.route+ "/0"
                                )
                            }
                        ){
                            navController.navigate(
                                ScreensController.ArticuloScreen.route+ "/$it"
                            )
                        }
                    }
                    composable(ScreensController.ArticuloScreen.route+"/{id}",
                        arguments = listOf(navArgument("id"){type = NavType.IntType})
                    ) {
                        val id = it.arguments?.getInt("id") ?: 0
                        ArticuloScreen(
                            id= id,
                            onSave = { navController.navigateUp() }
                        )
                    }
                }
            }
        }
    }
}
