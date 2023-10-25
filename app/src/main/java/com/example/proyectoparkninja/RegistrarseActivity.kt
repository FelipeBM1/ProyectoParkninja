package com.example.proyectoparkninja

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RegistrarseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrarse)

        val botonCrearCuenta:Button = findViewById(R.id.botonCrearCuenta)
        val intent1 = Intent (this, InicioActivity::class.java)

        botonCrearCuenta.setOnClickListener(){
            startActivity(intent1)
        }
    }
}