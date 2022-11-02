package com.example.repasojueves

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
        binding.btnregistrarusuario.setOnClickListener{
            guardar()
        }
    }
    fun guardar(){
        val txtnombre=binding.nombre.text.toString()
        val txtapellido=binding.apellido.text.toString()
        val txtcorreo=binding.correo.text.toString()
        val txtcelular=binding.celular.text.toString()
        val txtusuario=binding.usuario.text.toString()
        val txtclave=binding.clave.text.toString()
        val datos=getSharedPreferences("bdusuario",Context.MODE_PRIVATE)
        val editor=datos.edit()
        editor.putString("nombre",txtnombre)
        editor.putString("apellido",txtapellido)
        editor.putString("correo",txtcorreo)
        editor.putString("celular",txtcelular)
        editor.putString("usuario",txtusuario)
        editor.putString("clave",txtclave)
        editor.commit()
        Toast.makeText(this,"Datos guardados",Toast.LENGTH_LONG).show()
    }
}