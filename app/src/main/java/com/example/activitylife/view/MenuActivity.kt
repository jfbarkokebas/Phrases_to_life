package com.example.activitylife.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.activitylife.R
import com.example.activitylife.databinding.ActivityMenuBinding
import com.example.activitylife.services.PhrasesRepository

class MenuActivity (context: Context) : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMenuBinding
    private val repository: PhrasesRepository = PhrasesRepository.getInstance(context)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setListeners()

    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_store) {
            val phrase = binding.editPastePhrase.text.toString()
            //fazer uma logica para escolha da categoria
            repository.save()
        }
    }

    private fun setListeners(){
        binding.buttonStore.setOnClickListener(this)
    }
}