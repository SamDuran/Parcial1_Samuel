package edu.ucne.parcial1_samuel.ui

sealed class ScreensController(
    val route: String
) {
    object ArticuloScreen : ScreensController("Articulo")
    object ArticuloListScreen : ScreensController("ArticuloList")
}