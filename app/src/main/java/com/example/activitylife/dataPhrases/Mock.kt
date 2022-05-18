package com.example.activitylife.dataPhrases

import com.example.activitylife.infra.AppConstants
import kotlin.random.Random

class Mock {

    val cookie =  AppConstants.CATEGORY.COOKIE
    val warning = AppConstants.CATEGORY.WARNING
    val sad =  AppConstants.CATEGORY.SAD

    val myListPhrases = listOf(

        Phrase("Viver é melhor que sonhar", cookie),
        Phrase("Eu sei que o amor é uma coisa boa", cookie),
        Phrase("Tolice é viver a vida assim, sem aventura", cookie),
        Phrase("Enganoso é o coração do homem", warning),
        Phrase("Até o tolo de passa por sábio quando se cala", warning),
        Phrase("Para resultados diferentes, faça coisas diferentes", warning),
        Phrase("hoje vai ser massa!", sad),
        Phrase("Após a noite sempre chega o sol", sad),
        Phrase("Levanta sacode a poeira e dá a volta por cima", sad)

    )

    fun getPhrase(type: Int): String {
        val filtered = myListPhrases.filter { it.categoryId == type}//CORRIGIR ESSA LOGICA!!!!!!!!!'.
        return  filtered[Random.nextInt(filtered.size)].phrase
    }

}

