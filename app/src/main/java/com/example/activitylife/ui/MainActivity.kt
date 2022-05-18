package com.example.activitylife.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.activitylife.infra.AppConstants
import com.example.activitylife.infra.DataShared
import com.example.activitylife.R
import com.example.activitylife.dataPhrases.Mock
import com.example.activitylife.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    var categoryId = AppConstants.CATEGORY.COOKIE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //esconder a supportActionBar
        supportActionBar?.hide()

        //pegar o nome no SharedPreferences e lançar na tela
        handleUserName()
        //fingir que clicou para ja deixar selecionado o btn cookie
        handleFilter(R.id.image_cookie)

        //criação dos eventos
        binding.imageCookie.setOnClickListener(this)
        binding.imageSad.setOnClickListener(this)
        binding.imageWarning.setOnClickListener(this)
        binding.btnNewPhrase.setOnClickListener(this)
    }

    override fun onClick(view: View) {
       if (view.id == R.id.btn_newPhrase){
           binding.editPhrase.text = Mock().getPhrase(categoryId)
       }else if (view.id in listOf(R.id.image_cookie, R.id.image_sad, R.id.image_warning)){
           handleFilter(view.id)
       }
    }



    private fun handleFilter(id:Int){
        binding.imageCookie.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageSad.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageWarning.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))

        when (id) {
            R.id.image_cookie -> {
                binding.imageCookie.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = AppConstants.CATEGORY.COOKIE
                binding.editPhrase.text = Mock().getPhrase(categoryId)


            }
            R.id.image_sad -> {
                binding.imageSad.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = AppConstants.CATEGORY.SAD
                binding.editPhrase.text = Mock().getPhrase(categoryId)
            }
            R.id.image_warning -> {
                binding.imageWarning.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = AppConstants.CATEGORY.WARNING
                binding.editPhrase.text = Mock().getPhrase(categoryId)

            }
        }
    }

    private fun handleUserName(){
        val name = DataShared(this).getData(AppConstants.KEY.USER_NAME)
        binding.textHello.text = "Olá ${name}!"
    }
}