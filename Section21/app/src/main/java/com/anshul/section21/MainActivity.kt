package com.anshul.section21

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    lateinit var name: TextInputEditText
    lateinit var email: TextInputEditText
    lateinit var phone: TextInputEditText
    lateinit var signIn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.name)
        email = findViewById(R.id.email)
        phone = findViewById(R.id.phone)
        signIn = findViewById(R.id.signIn)


        signIn.setOnClickListener {

            val name = name.text.toString()
            val email = email.text.toString()
            val phone = phone.text.toString().toLong()

            val intent = Intent(this, SecondAcitvity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("email", email)
            intent.putExtra("phone", phone)
            startActivity(intent)

        }

    }
}