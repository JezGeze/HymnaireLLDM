package com.jezdevcode.hymnairelldm

import android.content.Context
import com.jezdevcode.hymnairelldm.database.Hymn
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object JsonManager {
    
    //Esta función convierte los objetos json a texto (JSON -> String)
    // Devolverà una List de la clase data class Hymn
    fun loadHymns(context: Context): List<Hymn> {
        //context.assets = Ve a la carpeta assets
        val jsonString = context.assets
        //abre el archivo hymns.json
        .open("hymns.json")
        //convierte el archivo en algo que se pueda leer facilmente
         .bufferedReader()
        //Lee todo el archivo, conviertelo en String, cuando termines cierra el archivo automaticamente
        .use { it.readText() }
        //Al final lo guardarà como texto en la variable jsonString
        
        //Se crea una objeto de tipo Gson(), este serà nuestro traductor
        val gson = Gson()
        //TypeToken lo que hace es separar todo
        val type = object : TypeToken<List<Hymn>>() {}.type
        val hymns: List<Hymn> = gson.fromJson(jsonString, type)
        
        return hymns
    }
}
