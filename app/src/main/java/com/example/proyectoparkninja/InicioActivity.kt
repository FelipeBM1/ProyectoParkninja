package com.example.proyectoparkninja

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class InicioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        val buscarBtn : ImageButton = findViewById(R.id.imgBtnBuscar)
        val subirFoto:Button =findViewById(R.id.subirFotoBtn)
        val tomarFoto:Button = findViewById(R.id.tomarFotoBtn)
        val intent1 = Intent(this, ParqueaderosCercanosActivity::class.java)
        val intent2 = Intent(this, ParqueaderosCercanosActivity::class.java)
        val main=MainActivity()


        tomarFoto.setOnClickListener(){
            val permissionsToCheck = arrayOf(Manifest.permission.CAMERA)
            if(!main.checkPermissions(permissionsToCheck)){
                main.requestCameraPermission(this)
            }
        }

        subirFoto.setOnClickListener(){
            val permissionsToCheck = arrayOf(Manifest.permission.CAMERA)
            if(!main.checkPermissions(permissionsToCheck)){
                main.requestCameraPermission(this)
            }
        }

        buscarBtn.setOnClickListener(){
            val permissionsToCheck = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)
            if(!main.checkPermissions(permissionsToCheck)){
                main.requestCameraPermission(this)
            }else{
                startActivity(intent1)
            }

        }


    }

    //permisos de ubicacion



    private fun openCamera() {
        Toast.makeText(this, "Abriendo Cámara", Toast.LENGTH_SHORT).show()
    }



    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==15){//nuestros permisos
            if(grantResults.isNotEmpty()&& grantResults[0] == PackageManager.PERMISSION_GRANTED){
                openCamera()
            }else{
                //el permiso no ha sido aceptado
                Toast.makeText(this, "Permisos rechazados por primera vez", Toast.LENGTH_SHORT).show()
            }
        }
    }




}