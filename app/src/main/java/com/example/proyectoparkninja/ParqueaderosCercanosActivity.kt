package com.example.proyectoparkninja

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class ParqueaderosCercanosActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    public class Parqueadero(
        val longitud: Double,
        val latitud: Double,
        val nombre: String,
        val precio: Double
    )
    val parqueadero1 = Parqueadero(4.6284875,-74.0672394,"par1",23.0)
    val parqueadero2 = Parqueadero(4.6284875,-74.0672394,"par2",14.2)
    val parqueadero3 = Parqueadero(4.6282095,-74.064525,"par3",31.3)
    val parqueadero4 = Parqueadero(4.6280384,-74.0633019,"par4",2.1)
    val parqueadero5 = Parqueadero(4.6252366,-74.0655657,"par5",23.4)
    val parqueadero6 = Parqueadero(4.6241458,-74.0674647,"par6",53.4)



    private val markerLocations = arrayListOf(
        LatLng(4.6284875,-74.0672394),LatLng(4.6284875,-74.0672394)
        ,LatLng(4.6282095,-74.064525),LatLng(4.6280384,-74.0633019),
        LatLng(4.6252366,-74.0655657),LatLng(4.6241458,-74.0674647)
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parqueaderos_cercanos)

        val botonPrecios: Button = findViewById(R.id.botonPrecios)
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        botonPrecios.setOnClickListener(){
            intent = Intent(this,PreciosParqueaderosCercanosActivity::class.java)

        }


    }
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Configura la cámara en una ubicación específica y con un nivel de zoom
        val Javeriana = LatLng(4.6284875,-74.0672394) // Por ejemplo, Nueva York
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Javeriana, 10.0f))

        // Agrega marcadores al mapa
        for (location in markerLocations) {
            mMap.addMarker(MarkerOptions().position(location))
        }
    }

}

