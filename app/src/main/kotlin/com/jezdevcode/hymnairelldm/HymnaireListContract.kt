package com.jezdevcode.hymnairelldm

interface HymnaireListContract {
    
    interface HLView{
        fun insertInitialHymns()
        fun showTextCantoNumber()
    }
    interface HLPresenter{
        fun getInitialHymns()
        fun showCantoNumber() : String
        fun showCantoTitle() : String
        fun showCantoBody() : String
    }
    interface Cantos{
        suspend fun loadInitialHymns()
        fun sendCantoNumber() : String
        fun sendCantoTitle() : String
        fun sendCantoBody() : String
    }
}
