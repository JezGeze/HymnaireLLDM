package com.jezdevcode.hymnairelldm.database

import androidx.room.Entity
import androidx.room.PrimaryKey

//Paso 1
//La notacion @Entity guarda el nombre de la tabla
// Y aqui se guardan los nombres de cada columna, cada variable es una columna nueva
// Es únicamente un objeto que representa un himno
// Paso 2 sigue el DAO
@Entity(tableName = "hymns")
data class Hymn(
    
    @PrimaryKey
    val hymnNumber: Int,
    
    val hymnFrenchTitle: String,
    val hymnSpanishTitle: String,
    val hymnTematic: String,
    val hymnFirstVerse: String,
    val hymnChorus: String,
    val hymnVerse: String,
    val favoriteHymn: Boolean = false
    
)
