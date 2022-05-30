package com.example.activitylife.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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

        supportActionBar?.hide()

        //pegar o nome no SharedPreferences e lançar na tela
        sharedName()
        handleFilter(R.id.image_cookie)

        //criação dos eventos
        setEvents()
    }

    override fun onResume() {
        super.onResume()
        sharedName()
    }

    override fun onClick(view: View) {
       if (view.id == R.id.btn_newPhrase){
           binding.editPhrase.text = Mock().getPhrase(categoryId)
       }else if (view.id in listOf(R.id.image_cookie, R.id.image_sad, R.id.image_warning)){
           handleFilter(view.id)
       }else if(view.id == R.id.text_hello){
           startActivity(Intent(this, UserActivity::class.java))
       }else if(view.id == R.id.image_menu){
           startActivity(Intent(this, MenuActivity::class.java))
       }
    }

    private fun setEvents(){
        binding.imageMenu.setOnClickListener(this)
        binding.textHello.setOnClickListener(this)
        binding.imageCookie.setOnClickListener(this)
        binding.imageSad.setOnClickListener(this)
        binding.imageWarning.setOnClickListener(this)
        binding.btnNewPhrase.setOnClickListener(this)
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

    private fun sharedName(){
        val name = DataShared(this).getData(AppConstants.KEY.USER_NAME)
        binding.textHello.text = "Olá ${name}!"
    }
}