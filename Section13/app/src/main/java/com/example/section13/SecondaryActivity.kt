package com.example.section13

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondaryActivity : AppCompatActivity() {

    //Intent second
    lateinit var result : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.secondactivity)

        result = findViewById(R.id.Result)

        var userName : String = intent.getStringExtra("user name").toString()
        var userAge : Int = intent.getIntExtra("user age", 0)

        "Hello $userName, you are $userAge years old".also { result.text = it }
//        result.text = "Hello $userName, you are $userAge years old"

    }
}