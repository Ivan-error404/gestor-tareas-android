package com.ivan.gestortareas.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Tarea::class], version = 1, exportSchema = false)
abstract class TareaDatabase : RoomDatabase() {

    abstract fun tareaDao(): TareaDao

    companion object {
        @Volatile
        private var INSTANCIA: TareaDatabase? = null

        fun obtener(contexto: Context): TareaDatabase =
            INSTANCIA ?: synchronized(this) {
                Room.databaseBuilder(
                    contexto.applicationContext,
                    TareaDatabase::class.java,
                    "gestor_tareas.db"
                ).build().also { INSTANCIA = it }
            }
    }
}
