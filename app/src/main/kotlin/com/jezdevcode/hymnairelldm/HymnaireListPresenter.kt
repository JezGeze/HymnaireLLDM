package com.jezdevcode.hymnairelldm

import com.jezdevcode.hymnairelldm.HymnaireListContract.HLPresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HymnaireListPresenter (private val viewHL: HymnaireListContract.HLView, private val modelHL: HymnaireListContract.Cantos ) : HymnaireListContract.HLPresenter{

    override fun getInitialHymns() {
        CoroutineScope(Dispatchers.IO).launch {
            modelHL.loadInitialHymns()
        }
    }
    
    override fun getAllFrenchTitle() {
        
        CoroutineScope(Dispatchers.IO).launch {
            val frenchTitles = modelHL.getAndSendAllHymnsFrenchsTitles()
            withContext(Dispatchers.Main){
                viewHL.showFrenchTitles(frenchTitles)
            }
        }
        
    }
    
}
