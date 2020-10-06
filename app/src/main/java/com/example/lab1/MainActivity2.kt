package com.example.lab1

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("INFO",   "MainActivity2 onCreate start")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val callTaxiButton = findViewById<Button>(R.id.callTaxiButton)
        callTaxiButton.isEnabled = false;
        callTaxiButton.isClickable = false;

        val userName = intent.getStringExtra("Name")
        val userSurname = intent.getStringExtra("Surname")
        val userPhoneNumber = intent.getStringExtra("PhoneNumber")

        val fullName = findViewById<TextView>(R.id.textView);
        val phoneNumber = findViewById<TextView>(R.id.textView2);

        fullName.text = "$userName $userSurname";
        phoneNumber.text = userPhoneNumber;

        val setPathButton = findViewById<Button>(R.id.button2)

        setPathButton.setOnClickListener {
            Log.d("INFO",   "MainActivity2 setOnClickListener start")

            val intent = Intent(this@MainActivity2, MainActivity3::class.java)
            startActivityForResult(intent, 2)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.d("INFO",   "MainActivity2 onActivityResult start")

        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 2) {
            val callTaxiButton = findViewById<Button>(R.id.callTaxiButton)
            callTaxiButton.isEnabled = true;
            callTaxiButton.isClickable = true;

            callTaxiButton.setOnClickListener {
                val text = "Wait for Taxi. Good Luck!"
                val duration = Toast.LENGTH_SHORT

                val toast = Toast.makeText(applicationContext, text, duration)
                toast.show()
            }

            val p1p2text = findViewById<TextView>(R.id.p1p2text)
            if (data != null) {
                p1p2text.text = ("Taxi will arrive at " + data.getStringExtra("p1Street") + ' ' + data.getStringExtra("p1House") + ' ' + data.getStringExtra("p1Flat") + "in 5 minutes and take you in " + data.getStringExtra("p2Street") + ' ' + data.getStringExtra("p2House") + ' ' + data.getStringExtra("p2Flat") + ". If you are agree click Call Taxi").toString()
            }


        }
    }
}