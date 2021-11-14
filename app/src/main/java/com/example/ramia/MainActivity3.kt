package com.example.ramia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity3 : AppCompatActivity() {
    lateinit var myMovies:Button
    lateinit var allMovies:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        myMovies = findViewById(R.id.button3)
        allMovies = findViewById(R.id.button4)

        myMovies.setOnClickListener {
//            startActivity(Intent(this,MainActivity2::class.java))
            supportFragmentManager.beginTransaction().replace(R.id.frag, myvi()).commit()

        }
        allMovies.setOnClickListener {
//            startActivity(Intent(this,MainActivity::class.java))
            supportFragmentManager.beginTransaction().replace(R.id.frag, allvi()).commit()
        }
    }
}