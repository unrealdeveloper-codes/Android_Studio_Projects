package com.anshul.section21part4

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val firstFragmentManager : FragmentManager = supportFragmentManager
        val firstFragmentTransaction = firstFragmentManager.beginTransaction()
        val firstFragment = FirstFragment()
        firstFragmentTransaction.add(R.id.frame, firstFragment)
        firstFragmentTransaction.commit()

    }
}