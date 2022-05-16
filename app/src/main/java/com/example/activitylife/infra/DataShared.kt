package com.example.activitylife.infra

import android.content.Context
import android.content.SharedPreferences

class DataShared(context: Context) {

    private val data: SharedPreferences =
        context.getSharedPreferences("Phrases", Context.MODE_PRIVATE)

    fun setData(key:String, value: String){
        data.edit().putString(key, value).apply()
    }

    fun getData(key: String):String{
        return data.getString(key, "não encontrado")?: ""
    }

}