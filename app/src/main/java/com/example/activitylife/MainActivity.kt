package com.example.activitylife

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.activitylife.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = DataShared(this).getData("USER_NAME")
        binding.textHello.text = "Olá ${name}!"
    }
}