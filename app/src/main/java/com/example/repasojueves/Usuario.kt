package com.example.repasojueves

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.repasojueves.databinding.ActivityUsuarioBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class Usuario : AppCompatActivity() {
    private lateinit var binding:ActivityUsuarioBinding
    private val db=FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityUsuarioBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val bundle=intent.extras
        val dato=bundle?.getString("ide")
        val txt=binding.llegadato
        txt.setText(dato)

        //obtenerdatos()
        consultarusuario(dato?:"")
        binding.btnconsultarpaseadores.setOnClickListener{
            startActivity(Intent(this,PaseadoresListado::class.java))
        }
    }
    fun obtenerdatos(){
        val cajatxt=binding.viewnombre
        val datos=getSharedPreferences("bdusuario", Context.MODE_PRIVATE)
        val nombre=datos.getString("nombre","")
        cajatxt.setText(nombre)
    }
    fun consultarusuario(id:String){
        db.collection("usuarios").document(id).get().addOnSuccessListener {
            binding.viewnombre.setText(it.get("nombre") as String? + it.get("apellido") as String?)
            binding.viewcorreo.setText(it.get("correo") as String?)
            binding.viewcelular.setText(it.get("celular") as String?)
        }
    }
}