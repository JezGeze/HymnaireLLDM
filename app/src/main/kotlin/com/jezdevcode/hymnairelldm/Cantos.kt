package com.jezdevcode.hymnairelldm
/*
import android.content.Context
//start Curso chatgpt
import com.jezdevcode.hymnairelldm.database.DatabaseProvider
import com.jezdevcode.hymnairelldm.database.HymnRepository
import com.jezdevcode.hymnairelldm.database.Hymn
import kotlinx.coroutines.flow.Flow
//end Curso chatgpt

class Cantos (private val context : Context) : HymnaireListContract.Cantos{
    //Start curso chatgpt
    private val db = DatabaseProvider.getDatabase(context)
    private val hymnDao = db.hymnDao()
    private val repository = HymnRepository(hymnDao)
    //end curso chatgpt
    
    val cantoNumber = "1"
    val cantoTitle = "Que dulce es tu nombre"
    val cantoBody = "Que dulce es tu nombre oh Jesus, bonanza has puesto en mi corazon"
    
    override fun sendCantoNumber() : String{
        return cantoNumber
    }
    override fun sendCantoTitle() : String{
        return cantoTitle
    }
    override fun sendCantoBody() : String{
        return cantoBody
    }
    
    //start curso chatgpt
   /* override fun getAllHymns(): Flow<List<Hymn>> {
        return repository.getAllHymns()
    }
    
    suspend fun saveFavorite(hymn: Hymn){
        repository.saveFavorite(hymn)
    }
    //end curso chatgpt
     */
}
*/

import android.content.Context


class Cantos (private val context : Context) : HymnaireListContract.Cantos{
    
    
    val cantoNumber = "1"
    val cantoTitle = "Que dulce es tu nombre"
    val cantoBody = "Que dulce es tu nombre oh Jesus, bonanza has puesto en mi corazon"
    
    override fun sendCantoNumber() : String{
        return cantoNumber
    }
    override fun sendCantoTitle() : String{
        return cantoTitle
    }
    override fun sendCantoBody() : String{
        return cantoBody
    }
    
  
}

