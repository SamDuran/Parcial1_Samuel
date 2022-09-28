package edu.ucne.parcial1_samuel.data.repository

import edu.ucne.parcial1_samuel.data.local.AppDataBase
import edu.ucne.parcial1_samuel.data.local.dao.ArticuloDao
import edu.ucne.parcial1_samuel.data.local.entities.Articulo
import javax.inject.Inject

class ArticuloRepository @Inject constructor(
    private val db: AppDataBase
) {
    suspend fun insert(articulo: Articulo) = db.articuloDao.insert(articulo)

    suspend fun delete(articulo: Articulo) = db.articuloDao.delete(articulo)

    suspend fun findById(id:Int) = db.articuloDao.find(id)

    fun getArticulos() = db.articuloDao.getArticulos()
}