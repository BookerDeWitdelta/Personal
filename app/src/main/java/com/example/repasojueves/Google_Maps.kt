package com.example.repasojueves

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.repasojueves.databinding.ActivityGoogleMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class google_maps : AppCompatActivity(),OnMapReadyCallback{
    private lateinit var binding:ActivityGoogleMapsBinding
    private lateinit var map: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGoogleMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        crearfragment()
    }
    private fun crearfragment() {
        val mapFrament: SupportMapFragment=supportFragmentManager.findFragmentById(R.id.map)as SupportMapFragment
        mapFrament.getMapAsync(this)
    }

    override fun onMapReady(gm: GoogleMap) {
        map=gm
        crearMarker()
    }
    private fun crearMarker(){
        val coordenadas=LatLng(5.654564892,9.4654892)
        val marker:MarkerOptions=MarkerOptions().position(coordenadas).title("El lagito")
        map.addMarker(marker)
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(coordenadas,14f),5000,null)
    }
}