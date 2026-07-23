package com.jezdevcode.hymnairelldm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.jezdevcode.hymnairelldm.JsonManager
import com.jezdevcode.hymnairelldm.database.DatabaseProvider
import com.jezdevcode.hymnairelldm.database.HymnRepository
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class HymnaireListActivity : AppCompatActivity(), HymnaireListContract.HLView {
    private lateinit var txtFrenchTitle: TextView
    
    
    private lateinit var presenterHL: HymnaireListContract.HLPresenter
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hymnaire_list)
        
        presenterInit()
        getViews()
        insertInitialHymns()
        presenterHL.getAllFrenchTitle()
        
    }
    
    //Start Metodos propios de la activity *********************************************************************************
    
    fun presenterInit(){
        presenterHL = HymnaireListPresenter(this,Cantos(this))
    }
    
    fun getViews(){
        txtFrenchTitle = findViewById(R.id.txt_french_title)
    }
    
    //Start metodos Room ******************************************************************************************************
    
    override fun insertInitialHymns(){
        presenterHL.getInitialHymns()
    }
    
    override fun showFrenchTitles(frenchTitlesList: List<String>){
        txtFrenchTitle.text = frenchTitlesList.joinToString("\n")
    }
    
    //Metodos de prueba, para borrar ******************************************************************************************
    
    //Este mètodo es de prueba
    // pruebaJson() carga del JsonManager la lista de himnos del Json a través de Gson y se lo pasa al texto view
    fun pruebaJson(){
        val hymn = JsonManager.loadHymns(this)
        txtNumber.text = hymn.toString()
    }
    
}