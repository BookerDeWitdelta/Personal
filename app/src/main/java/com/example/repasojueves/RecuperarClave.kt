package com.example.repasojueves

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.repasojueves.databinding.ActivityRecuperarClaveBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RecuperarClave : AppCompatActivity() {
    private lateinit var binding: ActivityRecuperarClaveBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityRecuperarClaveBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        firebaseAuth=Firebase.auth
        binding.txtcorreorecuperar.setOnClickListener{
            recuperarclave(binding.txtcorreorecuperar.text.toString())
        }
    }
    private fun  recuperarclave(email:String){
        firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(){
            task->
            if(task.isSuccessful){
                Toast.makeText(this,"Se envio correo de recuperacion",Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this,"No fue posible enviar el texto",Toast.LENGTH_LONG).show()
            }
        }
    }
}