package com.jezdevcode.hymnairelldm.database

import androidx.room.Entity
import androidx.room.PrimaryKey

//La notacion @Entity guarda el nombre de la tabla
// Y aqui se guardan los nombres de cada columna, cada variable es una columna nueva
@Entity(tableName = "hymns")
data class Hymn(
    
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val hymnNumber: Int,
    val hymnFrenchTitle: String,
    val hymnSpanishTitle: String,
    val hymnTematic: String,
    val hymnVerse: String,
    val hymnChorus: String,
    val favoriteHymn: Boolean = false
    
)
