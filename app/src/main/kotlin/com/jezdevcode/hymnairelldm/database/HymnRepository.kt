package com.jezdevcode.hymnairelldm.database

import kotlinx.coroutines.flow.Flow
import com.jezdevcode.hymnairelldm.JsonManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import android.content.Context

//Paso 5:
//Repository es el intermediario entre el presenter y Room/DAO. o entre el Model y Room
//Si el día de mañana queremos sustituir Room por otra base de datos, borramos Room y modificamos solamente el Repository
// Su función es decidir de donde viene la información que se le va a pasar al Model y al Presenter.

class HymnRepository(private val context: Context ,private val hymnDao: HymnDao) {
    
    suspend fun insertInitialHymns(){
        withContext(Dispatchers.IO){
        
            val count = hymnDao.countHymns()

            if(count == 0){

                val hymns = JsonManager.loadHymns(context)

                hymnDao.insertAllHymns(hymns)

            }
        }
    }
    
    suspend fun getAllHymnFrenchTitle(): List<String>{
        return hymnDao.getAllHymnFrenchTitle()
    }
    
    //también podría quedar asi
    // fun getAllHymns() = hymnDao.getAll()
     fun getAllHymns(): Flow<List<Hymn>>{
        return hymnDao.getAll()
     }
    
    /*
    suspend fun saveFavorite(hymn: Hymn){
        hymnDao.insertFavorite(hymn)
    }
     */
     
}
