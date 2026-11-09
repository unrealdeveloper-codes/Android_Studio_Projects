package com.anshul.section21

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SecondAcitvity : AppCompatActivity() {

    lateinit var resultName: TextView
    lateinit var resultEmail: TextView
    lateinit var resultPhone: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second_acitvity)

        resultName = findViewById(R.id.resultName)
        resultEmail = findViewById(R.id.resultEmail)
        resultPhone = findViewById(R.id.resultPhone)


        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val phone = intent.getLongExtra("phone", 0)

        resultName.text = name
        resultEmail.text = email
        resultPhone.text = phone.toString()


    }
}