package com.example.repasojueves

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.repasojueves.model.Paseadorrecycler

class AdaptadorPaseador(private  val context:Context,val lista:MutableList<Paseadorrecycler>):
        RecyclerView.Adapter<AdaptadorPaseador.ViewHolder>(){
                inner class ViewHolder(itemsview:View):RecyclerView.ViewHolder(itemsview){
                        lateinit var datosnombre:TextView
                        lateinit var  datoscorreo:TextView
                        init {
                            datosnombre=itemsview.findViewById(R.id.txtnombre)
                            datoscorreo=itemsview.findViewById(R.id.txtcorreo)
                        }
                }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
                val view=LayoutInflater.from(parent.context).inflate(R.layout.cardpaseador,parent,false)
                return(ViewHolder(view))
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                val positionpaseador=lista[position]
                holder.datosnombre.text=positionpaseador.nombre
                holder.datoscorreo.text=positionpaseador.correo
        }

        override fun getItemCount(): Int {
                return lista.size

        }
}
