package com.example.lab1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("INFO",   "MainActivity onCreate start")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById(R.id.button) as Button;
        val sharedPreference = getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)

        val name = findViewById<EditText>(R.id.editTextTextPersonName)
        val surname = findViewById<EditText>(R.id.editTextTextPersonName2)
        val phone = findViewById<EditText>(R.id.editTextPhone)
        var is_logged_flag = false;

        if (sharedPreference.contains("username")) {
            name.setText(sharedPreference.getString("username", null).toString())
            surname.setText(sharedPreference.getString("usersurname", null).toString())
            phone.setText(sharedPreference.getString("phonenumber", null).toString())
            button.text = "Log in"
            is_logged_flag = true
        }


        button.setOnClickListener {
            Log.d("INFO",   "MainActivity setOnClickListener start")

            if (!is_logged_flag) {
                var editor = sharedPreference.edit()
                editor.putString("username", findViewById<EditText>(R.id.editTextTextPersonName).text.toString())
                editor.putString("usersurname", findViewById<EditText>(R.id.editTextTextPersonName2).text.toString())
                editor.putString("phonenumber", findViewById<EditText>(R.id.editTextPhone).text.toString())
                editor.commit()
            }

            val intent = Intent(this@MainActivity,MainActivity2::class.java)

            intent.putExtra("Name", findViewById<EditText>(R.id.editTextTextPersonName).text.toString())
            intent.putExtra("Surname", findViewById<EditText>(R.id.editTextTextPersonName2).text.toString())
            intent.putExtra("PhoneNumber", findViewById<EditText>(R.id.editTextPhone).text.toString())

            startActivity(intent);
        }
    }
}