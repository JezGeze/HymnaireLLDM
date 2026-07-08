package com.jezdevcode.hymnairelldm

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import com.jezdevcode.hymnairelldm.JsonManager

class HymnaireListActivity : Activity(), HymnaireListContract.HLView {
    private lateinit var txtNumber: TextView
    private lateinit var txtPrueba: TextView
    
    private lateinit var presenterHL: HymnaireListContract.HLPresenter
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hymnaire_list)
        
        presenterInit()
        getViews()
        //showTextCantoNumber()
        pruebaJson(
            
            
        )
    }
    
    fun presenterInit(){
        presenterHL = HymnaireListPresenter(this,Cantos(this))
    }
    
    fun getViews(){
        txtNumber = findViewById(R.id.txt_number)
        txtPrueba = findViewById(R.id.txt_prueba)
    }
    
    override fun showTextCantoNumber(){
        val number = presenterHL.showCantoNumber()
        val title = presenterHL.showCantoTitle()
        val body = presenterHL.showCantoBody()
        txtNumber.setText("$number , $title , $body ")
    }
    
    //Este mètodo es de prueba
    // pruebaJson() carga del JsonManager la lista de himnos del Json a través de Gson y se lo pasa al texto view
    fun pruebaJson(){
        val hymn = JsonManager.loadHymns(this)
        txtNumber.text = hymn.toString()
    }
}