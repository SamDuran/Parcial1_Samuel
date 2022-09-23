package edu.ucne.parcial1_samuel.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="entidad")
data class entity(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val campo1 : String,
    val campo2 : String,
    val campo3 : Double
)
