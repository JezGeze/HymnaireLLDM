package com.jezdevcode.hymnairelldm.database

import androidx.room.Database
import androidx.room.RoomDatabase

//Paso 3:
// El AppDatabase es el que le describe nuestra base de datos a Room:
// Le dice cuàl serà nuestra tabla, y cuàl serà nuestro DAO
// Què clase contiene la información de la tablas y què clase contiene nuestro DAO
// Paso 4: DatabaseProvider

@Database(
    entities = [Hymn::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    
    abstract fun hymnDao(): HymnDao   
}
