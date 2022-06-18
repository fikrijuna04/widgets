package com.example.widgets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.widgets.databinding.ActivityMainBinding


//Membuat variable binding
private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       //inisialisasi binding
       binding= ActivityMainBinding.inflate(layoutInflater)
        //memanggil layout dengan menggunakan binding.root
        setContentView(binding.root)


        val getData = intent.getParcelableExtra<ModelLogin>("data")
        binding.txtUserName.text = getData?.username.toString()
        binding.txPassword.text = getData?.password.toString()
        //Explicit intent memanggil Activity di projek yang sama
        binding.btnWidgets.setOnClickListener {
            val intent = Intent(this,widgets::class.java)
            startActivity(intent)
        }
        binding.btnIntentExplicit.setOnClickListener {
            val intent = Intent(this,implicitIntent::class.java)
            startActivity(intent)

        }
        }

    }
