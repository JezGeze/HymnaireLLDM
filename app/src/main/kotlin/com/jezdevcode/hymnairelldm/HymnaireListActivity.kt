package com.jezdevcode.hymnairelldm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.jezdevcode.hymnairelldm.JsonManager
import com.jezdevcode.hymnairelldm.database.DatabaseProvider
import com.jezdevcode.hymnairelldm.database.HymnRepository
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.jezdevcode.hymnairelldm.recyclerView.HymnaireListAdapter

class HymnaireListActivity : AppCompatActivity(), HymnaireListContract.HLView {
    //private lateinit var txtFrenchTitle: TextView
    
    private lateinit var recyclerView: RecyclerView
    
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
        //txtFrenchTitle = findViewById(R.id.txt_french_title)
        recyclerView = findViewById(R.id.rv_hymnaire_list_titles)
    }
    
    //Start metodos Room ******************************************************************************************************
    
    override fun insertInitialHymns(){
        presenterHL.getInitialHymns()
    }
    
    override fun showFrenchTitles(frenchTitlesList: List<String>){
        //val textToFormater = frenchTitlesList.joinToString("<br>")
        //textFrenchTitle.text = HtmlCompat.fromHtml(textToFormater, HtmlCompat.FROM_HTML_MODE_LEGACY)
        adaptersInfo(frenchTitlesList)
    }
    
    fun adaptersInfo(titlesList: List<String>){
        val adapter = HymnaireListAdapter(this, titlesList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
    
    //Metodos de prueba, para borrar ******************************************************************************************
    
    //Este mètodo es de prueba
    // pruebaJson() carga del JsonManager la lista de himnos del Json a través de Gson y se lo pasa al text view
    /*
    fun pruebaJson(){
        val hymn = JsonManager.loadHymns(this)
        txtFrenchTitle.text = hymn.toString()
    }*/
    
}