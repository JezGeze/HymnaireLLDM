package com.jezdevcode.hymnairelldm

import android.content.Context
import com.jezdevcode.hymnairelldm.database.DatabaseProvider
import com.jezdevcode.hymnairelldm.database.HymnRepository
import com.jezdevcode.hymnairelldm.database.Hymn


class Cantos (private val context : Context) : HymnaireListContract.Cantos{
    
    private val repository: HymnRepository
    
    //init crea una dependencia del repository (Para no crearlo en la activity)
    init {
        val db = DatabaseProvider.getDatabase(context)
        
        repository = HymnRepository(
            context,
            db.hymnDao()
        )
    }
    
    override suspend fun loadInitialHymns(){
        repository.insertInitialHymns()
    }
    
    override suspend fun getAndSendAllHymnsFrenchsTitles(): List<String>{
        val frenchTitles = repository.getAllHymnFrenchTitle()
        return frenchTitles
    }
  
}