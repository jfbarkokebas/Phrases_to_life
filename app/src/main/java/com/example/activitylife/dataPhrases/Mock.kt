package com.example.activitylife.dataPhrases

import com.example.activitylife.infra.AppConstants
import kotlin.random.Random

class Mock {

    val cookie = AppConstants.CATEGORY.COOKIE
    val warning = AppConstants.CATEGORY.WARNING
    val sad = AppConstants.CATEGORY.SAD

    val myListPhrases = listOf(

        Phrase("Viver é melhor que sonhar", cookie),
        Phrase("Eu sei que o amor é uma coisa boa", cookie),
        Phrase("Tolice é viver a vida assim, sem aventura", cookie),
        Phrase("Enganoso é o coração do homem", warning),
        Phrase("Até o tolo de passa por sábio quando se cala", warning),
        Phrase("Para resultados diferentes, faça coisas diferentes", warning),
        Phrase("hoje vai ser massa!", sad),
        Phrase("Enquanto não estivermos comprometidos, haverá exitação", sad),
        Phrase("Após a noite sempre chega o sol", sad),
        Phrase("Levanta sacode a poeira e dá a volta por cima", sad),

        Phrase("Não sabendo que era impossível, foi lá e fez.", warning),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", sad),
        Phrase("Quando está mais escuro, vemos mais estrelas!", sad),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", sad),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", warning),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", cookie),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", cookie),
        Phrase("Você perde todas as chances que você não aproveita.", warning),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", sad),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", warning),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", warning),
        Phrase("Se você acredita, faz toda a diferença.", cookie),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", warning)

    )

    fun getPhrase(type: Int): String {
        val filtered =
            myListPhrases.filter { it.categoryId == type }
        return filtered[Random.nextInt(filtered.size)].phrase
    }

}

