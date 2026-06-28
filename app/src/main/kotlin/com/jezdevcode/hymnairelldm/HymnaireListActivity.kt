package com.jezdevcode.hymnairelldm
import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class HymnaireListActivity : Activity(), HymnaireListContract.HLView {
    private lateinit var txtNumber: TextView
    
    private lateinit var presenterHL: HymnaireListContract.HLPresenter
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hymnaire_list)
        
        presenterInit()
        getViews()
        showTextCantoNumber()
    }
    
    fun presenterInit(){
        presenterHL = HymnaireListPresenter(this,Cantos(this))
    }
    
    fun getViews(){
        txtNumber = findViewById(R.id.txt_number)
    }
    
    override fun showTextCantoNumber(){
        val number = presenterHL.showCantoNumber()
        val title = presenterHL.showCantoTitle()
        val body = presenterHL.showCantoBody()
        txtNumber.setText("$number , $title , $body ")
    }
}