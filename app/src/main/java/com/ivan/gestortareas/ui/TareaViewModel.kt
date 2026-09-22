package com.ivan.gestortareas.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.ivan.gestortareas.data.Tarea
import com.ivan.gestortareas.data.TareaDatabase
import com.ivan.gestortareas.data.TareaRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TareaViewModel(application: Application) : AndroidViewModel(application) {

    private val repositorio = TareaRepository(
        TareaDatabase.obtener(application).tareaDao()
    )

    val tareas: StateFlow<List<Tarea>> = repositorio.tareas
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    fun agregar(titulo: String, descripcion: String) {
        if (titulo.isBlank()) return
        viewModelScope.launch {
            repositorio.agregar(titulo.trim(), descripcion.trim())
        }
    }

    fun eliminar(tarea: Tarea) {
        viewModelScope.launch {
            repositorio.borrar(tarea)
        }
    }

    fun alternar(tarea: Tarea) {
        viewModelScope.launch {
            repositorio.marcar(tarea.id, !tarea.completada)
        }
    }

    class Factory(private val app: Application) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(TareaViewModel::class.java)) {
                return TareaViewModel(app) as T
            }
            throw IllegalArgumentException("ViewModel desconocido: ${modelClass.name}")
        }
    }
}
