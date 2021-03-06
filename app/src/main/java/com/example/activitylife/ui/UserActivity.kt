package com.example.activitylife.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.activitylife.infra.AppConstants
import com.example.activitylife.infra.DataShared
import com.example.activitylife.R
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


        verifyUserActivity()


    }

    //ATRIBUINDO AÇÕES AOS BOTÕES DA TELA
    override fun onClick(view: View) {
        if(view.id == R.id.button_save){
            handleSave()
        }
    }
    //verificando se os dados ja foram inseridos

    fun verifyUserActivity(){
        val name = DataShared(this).getData(AppConstants.KEY.USER_NAME)
        if(name != ""){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    //TRATANDO OS DADOS DO CLICK
    fun handleSave(){
        val name = binding.editName.text.toString()
        if(name != ""){
            //salvar no shared preferences
            DataShared(this).setData(AppConstants.KEY.USER_NAME, name)
            //passar p outra activity
            startActivity(Intent(this, MainActivity::class.java))
            finish()

        }else{
            Toast.makeText(this, "Digite um nome válido.", Toast.LENGTH_SHORT).show()
        }
    }
}