package com.example.repasojueves

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.repasojueves.model.Paseadorrecycler

class AdaptadorPaseador(private  val context:Context,val lista:MutableList<Paseadorrecycler>, var clickListener:ClickListener):
        RecyclerView.Adapter<AdaptadorPaseador.ViewHolder>(){
                inner class ViewHolder(itemsview:View,listener: ClickListener):RecyclerView.ViewHolder(itemsview),View.OnClickListener{
                        var datosnombre:TextView
                        var datoscorreo:TextView
                        var datoscelular:TextView
                        var datosimagen:ImageView
                        var listener:ClickListener?=null
                        init {
                            datosnombre=itemsview.findViewById(R.id.txtnombre)
                            datoscorreo=itemsview.findViewById(R.id.txtcorreo)
                            datoscelular=itemsview.findViewById(R.id.txtcelular)
                            datosimagen=itemsview.findViewById(R.id.txtfoto)
                            this.listener=listener
                            itemsview.setOnClickListener(this)

                        }

                        override fun onClick(v: View?) {
                                this.listener?.OnClic(v!!,adapterPosition)
                        }
                }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
                val view=LayoutInflater.from(parent.context).inflate(R.layout.cardpaseador,parent,false)
                return ViewHolder(view,clickListener)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                val positionpaseador=lista[position]
                holder.datosnombre.text=positionpaseador.nombre+positionpaseador.apellido
                holder.datoscorreo.text=positionpaseador.correo
                holder.datoscelular.text=positionpaseador.celular
                Glide.with(holder.itemView).load(positionpaseador.imagen).into(holder.datosimagen)
        }

        override fun getItemCount(): Int {
                return lista.size

        }
}
