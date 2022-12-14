package edu.ucne.parcial1_samuel.data.local.dao

import androidx.room.*
import edu.ucne.parcial1_samuel.data.local.entities.Articulo
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticuloDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(articulo: Articulo)

    @Delete
    suspend fun delete(articulo: Articulo)

    @Query("SELECT * FROM Articulos WHERE articuloId = :id")
    suspend fun find(id:Int) : Articulo?

    @Query("SELECT * FROM Articulos")
    fun getArticulos() : Flow<List<Articulo>>
}