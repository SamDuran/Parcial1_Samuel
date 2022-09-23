package edu.ucne.parcial1_samuel.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.ucne.parcial1_samuel.data.local.entities.entity

@Database(
    entities = [entity::class],
    exportSchema = false,
    version =1
)
abstract class AppDataBase : RoomDatabase() {
    //daos
}