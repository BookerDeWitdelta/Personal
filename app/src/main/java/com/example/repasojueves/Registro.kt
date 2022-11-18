package com.example.repasojueves

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import androidx.room.Room.Companion.databaseBuilder
import com.example.repasojueves.data.UusarioDB
import com.example.repasojueves.databinding.ActivityFotoBinding
import com.example.repasojueves.databinding.ActivityRegistroBinding
import com.example.repasojueves.model.UsuarioModdel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class Registro : AppCompatActivity() {
    private lateinit var binding:ActivityRegistroBinding
    private  lateinit var database:UusarioDB
    private val  db=FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*database=   Room.databaseBuilder(application,UusarioDB::class.java,UusarioDB.DATABASE_NAME).allowMainThreadQueries().build()*/
        binding=ActivityRegistroBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        val bundle=intent.extras
        val email:String?=bundle?.getString("email")
        binding.correo .setText(email)
        binding.btnircaptura.setOnClickListener{
            startActivity(Intent(this,Foto::class.java))
        }
        binding.btnregistrarusuario.setOnClickListener{
            val bundle=intent.extras
            val datoid:String?=bundle?.getString("id")
            guardatosfirestore(datoid?:"")
            startActivity(Intent(this,Login::class.java))
            Toast.makeText(this,"Datos Guardados",Toast.LENGTH_LONG).show()
            //guardar()
            //guardarconroom()
        }
    }
   /* fun guardar(){
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
    fun guardarconroom(){
        val txtnombre=binding.nombre.text.toString()
        val txtapellido=binding.apellido.text.toString()
        val txtcorreo=binding.correo.text.toString()
        val txtcelular=binding.celular.text.toString()
        val txtusuario=binding.usuario.text.toString()
        val txtclave=binding.clave.text.toString()
        val usu= UsuarioModdel(txtusuario,txtnombre,txtapellido,txtcorreo,txtcelular,txtclave)
        database.usuarioDAO.insertar(usu)
    }*/
    private fun guardatosfirestore(datoid:String){
        db.collection("usuarios").document(datoid).set(
            hashMapOf("nombre" to binding.nombre.text.toString(),"apellido" to binding.apellido.text.toString(), "correo" to binding.correo.text.toString(),"celular" to binding.celular.text.toString() )
        )
    }
}