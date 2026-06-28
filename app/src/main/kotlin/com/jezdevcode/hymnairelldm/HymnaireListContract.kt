package com.jezdevcode.hymnairelldm

interface HymnaireListContract {
    
    interface HLView{
        fun showTextCantoNumber()
    }
    interface HLPresenter{
        fun showCantoNumber() : String
        fun showCantoTitle() : String
        fun showCantoBody() : String
    }
    interface Cantos{
        fun sendCantoNumber() : String
        fun sendCantoTitle() : String
        fun sendCantoBody() : String
    }
}
