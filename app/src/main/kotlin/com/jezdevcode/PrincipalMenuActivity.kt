package com.jezdevcode.hymnairelldm

import android.app.Activity
import android.os.Bundle
import androidx.cardview.widget.CardView
import android.content.Intent
lateinit var cvHymnaire: CardView
lateinit var cvIndex: CardView

class PrincipalMenuActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal_menu)
        
        getViews()
        buttonsAction()
    }
    
    fun getViews(){
        cvHymnaire = findViewById(R.id.cv_hymnaire)
        cvIndex = findViewById(R.id.cv_index)
    }
    
    fun buttonsAction(){
        cvHymnaire.setOnClickListener{
            changeActivity(HymnaireListActivity::class.java)
        }
        cvIndex.setOnClickListener{
            changeActivity(HymnaireListActivity::class.java)
        }
    }
    
    fun changeActivity(activity : Class <*>){
        val intent = Intent(this,activity)
        startActivity(intent)
    }
}
