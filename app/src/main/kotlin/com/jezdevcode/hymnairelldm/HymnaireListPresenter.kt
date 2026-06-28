package com.jezdevcode.hymnairelldm

import com.jezdevcode.hymnairelldm.HymnaireListContract.HLPresenter

class HymnaireListPresenter (private val viewHL: HymnaireListContract.HLView, private val modelHL: HymnaireListContract.Cantos ) : HymnaireListContract.HLPresenter{
    
    override fun showCantoNumber() : String{
        val number = modelHL.sendCantoNumber()
        return number
    }
    
    override fun showCantoTitle() : String{
        val title = modelHL.sendCantoTitle()
        return title
    }
    
    override fun showCantoBody() : String{
        val body = modelHL.sendCantoBody()
        return body
    }
    
}
