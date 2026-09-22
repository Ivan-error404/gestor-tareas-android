package com.ivan.gestortareas.data

import kotlinx.coroutines.flow.Flow

class TareaRepository(private val dao: TareaDao) {

    val tareas: Flow<List<Tarea>> = dao.observarTodas()

    suspend fun agregar(titulo: String, descripcion: String): Long {
        return dao.insertar(
            Tarea(titulo = titulo, descripcion = descripcion)
        )
    }

    suspend fun borrar(tarea: Tarea) {
        dao.eliminar(tarea)
    }

    suspend fun marcar(id: Long, completada: Boolean) {
        dao.cambiarEstado(id, completada)
    }
}
