package com.example.repasojueves

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
            val usuario=binding.txtusuario.text.toString()
            val clave=binding.txtclave.text.toString()
            if(usuario.isEmpty()&&clave.isEmpty()){
                Toast.makeText(this,"No puedes tener datos vacios",Toast.LENGTH_LONG).show()
            }
            else if(usuario.toString().length<3){
                Toast.makeText(this,"El usuario debe tener mas de dos caracteres",Toast.LENGTH_LONG).show()
            }
            else if(usuario=="pepe" && clave=="123") {
                startActivity(Intent(this,Usuario::class.java))
            }
            else{
                Toast.makeText(this,"Datos incorrectos",Toast.LENGTH_LONG).show()
            }
        }

    }
}