package com.jezdevcode.hymnairelldm.database

import androidx.room.Insert
import androidx.room.Delete
import kotlinx.coroutines.flow.Flow
import androidx.room.Dao
import androidx.room.Query

//Aquí es donde se ponen las instrucciones que va a hacer nuestra base de datos
@Dao
interface HymnDao {
    
    //Hymn es el nombre de la data class
    @Insert
    suspend fun insertFavorite(hymn: Hymn)
    
    //Se utiliza Flow para que cada vez que se añada o borre informacion se actualize atumoaticamente
    @Query("SELECT * FROM hymns")
    fun getAll(): Flow<List<Hymn>>
    
    @Delete
    suspend fun delete(hymn: Hymn)
}
