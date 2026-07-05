package com.jezdevcode.hymnairelldm.database
import kotlinx.coroutines.flow.Flow

//Paso 5:
//Repository es el intermediario entre el presenter y Room/DAO. o entre el Model y Room
//Si el día de mañana queremos sustituir Room por otra base de datos, borramos Room y modificamos solamente el Repository
// Su función es decidir de donde viene la información que se le va a pasar al Model y al Presenter.

class HymnRepository(private val hymnDao: HymnDao) {
    //también podría quedar asi
    // fun getAllHymns() = hymnDao.getAll()
     fun getAllHymns(): Flow<List<Hymn>>{
        return hymnDao.getAll()
     }
    
    
    suspend fun saveFavorite(hymn: Hymn){
        hymnDao.insertFavorite(hymn)
    }
}
