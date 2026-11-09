package com.anshul.section21part3

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    lateinit var personName : TextView
    lateinit var password : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        personName = findViewById(R.id.name)
        password = findViewById(R.id.password)


        val firstFragmentManager : FragmentManager = supportFragmentManager
        val firstFragmentTransaction : FragmentTransaction = firstFragmentManager.beginTransaction()
        val firstFragment = FirstFragment()
        firstFragmentTransaction.add(R.id.frame, firstFragment)
        firstFragmentTransaction.commit()



    }
}