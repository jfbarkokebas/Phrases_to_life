package com.example.activitylife.services

import android.content.ContentValues
import android.content.Context
import androidx.core.content.contentValuesOf
import com.example.activitylife.constants.dbConstants
import com.example.activitylife.dataPhrases.Phrase
import java.lang.Exception

class PhrasesRepository private constructor(context: Context) {

    private var dbHelper: PhrasesDBHelper = PhrasesDBHelper(context)

    companion object{
        private lateinit var repository: PhrasesRepository

        fun getInstance(context: Context): PhrasesRepository{
            if (!::repository.isInitialized){
                repository = PhrasesRepository(context)
            }
            return repository
        }
    }
    // cuidando do save30/05
    fun save(phrase: Phrase){
        try {
            val contentValues = ContentValues()
            contentValues.put(dbConstants.PHRASE.COLUMNS.NAME, phrase.text)

            val db = dbHelper.writableDatabase
            db.insert("frases", null, contentValues)

        }catch (e: Exception){
            false
        }
    }



}