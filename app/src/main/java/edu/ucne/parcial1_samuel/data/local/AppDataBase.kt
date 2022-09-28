package edu.ucne.parcial1_samuel.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.ucne.parcial1_samuel.data.local.dao.ArticuloDao
import edu.ucne.parcial1_samuel.data.local.entities.Articulo

@Database(
    entities = [Articulo::class],
    exportSchema = false,
    version =2
)
abstract class AppDataBase : RoomDatabase() {
    abstract val articuloDao : ArticuloDao
}