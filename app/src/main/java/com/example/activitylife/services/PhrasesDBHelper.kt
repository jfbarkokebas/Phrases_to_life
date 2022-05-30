package com.example.activitylife.services

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper



class PhrasesDBHelper(context: Context) :
    SQLiteOpenHelper(context, "data_phrases_life", null, 1) {



    companion object{

        private const val COLUMN_PHRASES = "Frases"
        private const val COLUMN_ID = "id"

    }


    override fun onCreate(bd: SQLiteDatabase?) {

    }

    override fun onUpgrade(bd: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}