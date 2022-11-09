package com.example.repasojueves.model
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "usuarios")
class UsuarioModdel (
    @PrimaryKey
    val nombreusuario:String,
    @ColumnInfo(name= "nombre")
    val nombre:String,
    @ColumnInfo(name= "apellido")
    val apelido:String,
    @ColumnInfo(name= "correo")
    val correo:String,
    @ColumnInfo(name= "celular")
    val celular:String,
    @ColumnInfo(name= "clave")
    val clave:String
)