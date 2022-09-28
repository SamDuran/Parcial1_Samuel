package edu.ucne.parcial1_samuel.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="Articulos")
data class Articulo(
    @PrimaryKey(autoGenerate = true)
    val articuloId:Int,
    val descripcion : String,
    val marca : String,
    val existencia : Double
)
