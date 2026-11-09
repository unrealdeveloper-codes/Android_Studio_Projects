package com.anshul.section20part2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val listFragmentManager : FragmentManager = supportFragmentManager
        val listFragmentTransaction : FragmentTransaction = listFragmentManager.beginTransaction()

        val listFragment = ListFragment()

        listFragmentTransaction.add(R.id.frame, listFragment)

        listFragmentTransaction.commit()


    }
}