package com.example.repasojueves

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.repasojueves.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        binding.btnlogin.setOnClickListener {
            validar()
        }
    }
    fun validar(){
        val txtusu=binding.txtusuario.text.toString()
        val txtcla=binding.txtclave.text.toString()
        val datos=getSharedPreferences("usuario",Context.MODE_PRIVATE)
        val usu=datos.getString("usuario","")
        val cla=datos.getString("clave","")
        if(txtusu.equals(usu)&& txtcla.equals(cla)){
            startActivity(Intent(this,Usuario::class.java))
        }
    }
}