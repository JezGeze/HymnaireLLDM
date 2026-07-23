package com.jezdevcode.hymnairelldm

interface HymnaireListContract {
    
    interface HLView{
        fun insertInitialHymns()
        fun showFrenchTitles(frenchTitlesList: List<String>)
    }
    interface HLPresenter{
        fun getInitialHymns()
        fun getAllFrenchTitle()
    }
    
    interface Cantos{
        suspend fun loadInitialHymns()
        suspend fun getAndSendAllHymnsFrenchsTitles(): List<String>
    }
}
