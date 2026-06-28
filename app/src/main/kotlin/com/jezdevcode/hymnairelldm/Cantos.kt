package com.jezdevcode.hymnairelldm

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
