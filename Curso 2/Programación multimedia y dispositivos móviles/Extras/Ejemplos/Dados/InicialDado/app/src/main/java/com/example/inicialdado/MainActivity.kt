package com.example.inicialdado

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var dado: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val botonLanzador: Button = findViewById<Button>(R.id.btLanzar)

        dado = findViewById(R.id.ivDado)

//        botonLanzador.setOnClickListener{
//            Toast.makeText(this, "Se ha pulsado boton lanzar", Toast.LENGTH_LONG).show()
//        }

    }
     fun lanzar(view: View?){

        Toast.makeText(this@MainActivity, "Se ha pulsado boton lanzar", Toast.LENGTH_LONG).show()
        Log.i("Principal", "boton pulsado")
         tirarDado()
         decirTirar()
    }

    private fun tirarDado() {
        val salio = Random.nextInt(6) + 1

        val img = when(salio){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }

        dado?.setImageResource(img)
    }

    private fun decirTirar() {
        // ====== aqui no esta bien.....  llevar a una variable de instancia y metodo en onCreate
        val txtTirar: TextView = findViewById(R.id.txtTirar) as TextView
        val salio = Random.nextInt(6) + 1
        txtTirar.text = "Dado=" + salio.toString()
    }

}
