package edu.ucne.parcial1_samuel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import edu.ucne.parcial1_samuel.ui.ScreensController
import edu.ucne.parcial1_samuel.ui.articulo.entityListScreen
import edu.ucne.parcial1_samuel.ui.articulo.entityScreen
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
                    startDestination = ScreensController.entityListScreen.route
                ) {
                    composable(ScreensController.entityListScreen.route) {
                        entityListScreen(
                            newEntityClick = {
                                navController.navigate(
                                    ScreensController.entityScreen.route
                                )
                            }
                        )
                    }
                    composable(ScreensController.entityScreen.route) {
                        entityScreen(onSave = { navController.navigateUp() })
                    }
                }
            }
        }
    }
}
