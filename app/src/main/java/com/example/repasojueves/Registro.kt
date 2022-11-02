package com.example.repasojueves

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.repasojueves.databinding.ActivityFotoBinding
import com.example.repasojueves.databinding.ActivityRegistroBinding

class Registro : AppCompatActivity() {
    private lateinit var binding:ActivityRegistroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityRegistroBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        binding.btnircaptura.setOnClickListener{
            startActivity(Intent(this,Foto::class.java))
        }
    }
}