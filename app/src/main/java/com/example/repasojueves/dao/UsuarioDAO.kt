package com.example.repasojueves.dao

import androidx.room.*
import com.example.repasojueves.model.UsuarioModdel

@Dao
interface UsuarioDAO{
    @Query("SELECT*FROM usuarios")
    fun consultar():List<UsuarioModdel>
    @Update
    fun actualizar(usuario:UsuarioModdel)
    @Insert
    fun insertar(usuario: UsuarioModdel)
    @Delete
    fun eliminar(usuario: UsuarioModdel)
}