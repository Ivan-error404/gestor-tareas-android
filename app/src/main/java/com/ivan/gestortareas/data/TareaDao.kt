package com.ivan.gestortareas.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TareaDao {

    @Query("SELECT * FROM tareas ORDER BY fechaCreacion DESC")
    fun observarTodas(): Flow<List<Tarea>>

    @Query("SELECT * FROM tareas WHERE completada = 0 ORDER BY fechaCreacion DESC")
    fun observarPendientes(): Flow<List<Tarea>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(tarea: Tarea): Long

    @Delete
    suspend fun eliminar(tarea: Tarea)

    @Query("UPDATE tareas SET completada = :completada WHERE id = :id")
    suspend fun cambiarEstado(id: Long, completada: Boolean)
}
