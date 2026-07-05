package com.jezdevcode.hymnairelldm.database

import android.content.Context
import androidx.room.Room

//Paso 4:
// DatabaseProvider es el administrador de la base de datos:
// Su ùnica misiòn es hacer esta pregunta: Existe la base de datos? Sì -> Devuelvela/cargala, No -> Creala y devuelvela/cargala
// Nunca Hace consultas, no guarda datos, solo administra la instancia/existencia de la base de datos
// Paso 5: Repository
object DatabaseProvider {
    private var database: AppDatabase? = null
    
    fun getDatabase(context: Context): AppDatabase{
        if (database == null){
            database = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "hymnaire.db"
            ).build()
        }
        return database!!
    }
}
