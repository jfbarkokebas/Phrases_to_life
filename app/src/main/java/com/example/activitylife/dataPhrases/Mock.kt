package com.example.activitylife.dataPhrases

import com.example.activitylife.infra.AppConstants

class Mock {

    val myListPhrases = listOf(

        Phrase("Viver é melhor que sonhar", AppConstants.CATEGORY.COOKIE),
        Phrase("Eu sei que o amor é uma coisa boa", AppConstants.CATEGORY.COOKIE),
        Phrase("Enganoso é o coração do homem", AppConstants.CATEGORY.WARNING),
        Phrase("Até o tolo de passa por sábio quando se cala", AppConstants.CATEGORY.WARNING),
        Phrase("hoje vai ser massa!", AppConstants.CATEGORY.SAD),
        Phrase("viver a divina comédia humana, onde nada é eterno", AppConstants.CATEGORY.SAD)

    )

    fun getPhrases(category: AppConstants.CATEGORY){
       //gerar um numero aleatorio[index] e pegar uma frase dentro da categoria das
    }

}