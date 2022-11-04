package com.example.repasojueves

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.repasojueves.databinding.ActivityUsuarioBinding

class Usuario : AppCompatActivity() {
    private lateinit var binding:ActivityUsuarioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityUsuarioBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val bundle=intent.extras
        val dato=bundle?.getString("nombre")
        val txt=binding.llegadato
        txt.setText(dato)

        obtenerdatos()
    }
    fun obtenerdatos(){
        val cajatxt=binding.viewnombre
        val datos=getSharedPreferences("bdusuario", Context.MODE_PRIVATE)
        val nombre=datos.getString("nombre","")
        cajatxt.setText(nombre)
    }
}