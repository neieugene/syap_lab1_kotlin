package com.example.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("INFO",   "MainActivity3 onCreate start")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val p1Street = findViewById<TextView>(R.id.p1Street)
        val p1House = findViewById<TextView>(R.id.p1House)
        val p1Flat = findViewById<TextView>(R.id.p1House)

        val p2Street = findViewById<TextView>(R.id.p2Street)
        val p2House = findViewById<TextView>(R.id.p2House)
        val p2Flat = findViewById<TextView>(R.id.p2Flat)

        val submitButton = findViewById<Button>(R.id.button3)

        submitButton.setOnClickListener {
            Log.d("INFO",   "MainActivity3 setOnClickListener start")

            val intent = Intent();

            intent.putExtra("p1Street", p1Street.text.toString())
            intent.putExtra("p1House", p1House.text.toString())
            intent.putExtra("p1Flat", p1Flat.text.toString())

            intent.putExtra("p2Street", p2Street.text.toString())
            intent.putExtra("p2House", p2House.text.toString())
            intent.putExtra("p2Flat", p2Flat.text.toString())

            setResult(2, intent)

            finish()
        }

    }
}