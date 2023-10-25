package com.example.proyectoparkninja

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private val REQUEST_CODE_PERMISSIONS = 123
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonIngresar: Button = findViewById(R.id.botonIngresar)
        val intent1 = Intent (this, InicioActivity::class.java)

        val botonRegistrate: Button = findViewById(R.id.botonRegistrate)
        val intent2 = Intent (this, RegistrarseActivity::class.java)

        botonIngresar.setOnClickListener(){
            startActivity(intent1)
        }

        botonRegistrate.setOnClickListener(){
            startActivity(intent2)
        }

    }
    fun checkPermissions(permissions: Array<String>): Boolean {
        for (permission in permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                return false
            }
        }
        return true
    }
    public fun requestLocationPermission(context : Activity) {
        if(ActivityCompat.shouldShowRequestPermissionRationale(context,Manifest.permission.ACCESS_FINE_LOCATION))
        {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf<String>(Manifest.permission.ACCESS_FINE_LOCATION),
                    10
                )

            }
        }

    }
    public fun requestCameraPermission(context : Activity) {
        if(ActivityCompat.shouldShowRequestPermissionRationale(context, Manifest.permission.CAMERA)){
            //El usuario ya ha rechazado los permisos
            Toast.makeText(this, "Permisos rechazados", Toast.LENGTH_SHORT).show()

        }else {
            //pedir permiso, porque aun no los ha rechazado
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA),15)
        }
    }

    public fun requestStoragePermission(context : Activity) {
        if (ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
            && ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {


        } else {
            ActivityCompat.requestPermissions(
                context,
                arrayOf<String>(
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                ),
                20
            )
        }
    }

}

