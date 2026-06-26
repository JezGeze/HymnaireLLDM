package com.jezdevcode.hymnairelldm

import android.app.Activity
import android.os.Bundle
import androidx.cardview.widget.CardView
import android.content.Intent
lateinit var cvHymnaire: CardView

class PrincipalMenuActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal_menu)
        
        getViews()
        buttonsAction()
    }
    
    fun getViews(){
        cvHymnaire = findViewById(R.id.cv_hymnaire)
    }
    
    fun buttonsAction(){
        cvHymnaire.setOnClickListener{
            val intent = Intent(this,HymnaireListActivity::class.java)
            startActivity(intent)
        }
    }
}
