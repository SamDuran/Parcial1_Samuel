package edu.ucne.parcial1_samuel.ui

sealed class ScreensController(
    val route: String
) {
    object entityScreen : ScreensController("entity")
    object entityListScreen : ScreensController("entityList")
}