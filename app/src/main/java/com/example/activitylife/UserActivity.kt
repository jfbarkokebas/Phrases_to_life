package com.example.activitylife

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.activitylife.databinding.ActivityMainBinding
import com.example.activitylife.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        //buttons...
        binding.buttonSave.setOnClickListener(this)


    }

    //ATRIBUINDO AÇÕES AOS BOTÕES DA TELA
    override fun onClick(view: View) {
        if(view.id == R.id.button_save){
            handleSave()
        }
    }

    //TRATANDO OS DADOS DO CLICK
    fun handleSave(){
        val name = binding.editName.text.toString()
        if(name != ""){
            //salvar no shared preferences
            DataShared(this).setData("USER_NAME", name)
            //passar p outra activity
            startActivity(Intent(this, MainActivity::class.java))
            finish()

        }else{
            Toast.makeText(this, "Digite um nome válido.", Toast.LENGTH_SHORT).show()
        }
    }
}