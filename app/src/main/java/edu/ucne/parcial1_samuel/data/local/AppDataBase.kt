package edu.ucne.parcial1_samuel.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [],
    exportSchema = false,
    version =1
)
abstract class AppDataBase : RoomDatabase() {

}