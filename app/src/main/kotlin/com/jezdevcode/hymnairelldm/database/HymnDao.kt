package com.jezdevcode.hymnairelldm.database

import androidx.room.Insert
import androidx.room.Delete
import kotlinx.coroutines.flow.Flow
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update

//Paso 2
//Aquí es donde se ponen las instrucciones que va a hacer nuestra base de datos
// Paso 3: AppDatabase
@Dao
interface HymnDao {
    
    //Hymn es el nombre de la data class 
    
    //insertHymn inserta un solo himno en la base de datos   
    @Insert 
    suspend fun insertHymn(hymn: Hymn)
    
    //insertAllHymns Este método es para insertar la base de datos proveniente de JsonManager que a su vez proviene del archivo JSON
    @Insert
    suspend fun insertAllHymns(hymnList: List<Hymn>)
    
    @Update
    suspend fun updateHymn(hymn: Hymn)
    
    @Delete
    suspend fun delete(hymn: Hymn)
    
    //Se utiliza Flow para que cada vez que se añada o borre informacion se actualize atumoaticamente
    @Query("SELECT * FROM hymns")
    fun getAll(): Flow<List<Hymn>>
    
    @Query("SELECT COUNT(*) FROM hymns")
    suspend fun countHymns(): Int
}
