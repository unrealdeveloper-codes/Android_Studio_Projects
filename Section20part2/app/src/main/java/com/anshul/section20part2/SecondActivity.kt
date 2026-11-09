package com.anshul.section20part2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager

class SecondActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        val position = intent.getIntExtra("position", 0)

        val secondFragmentManager : FragmentManager = supportFragmentManager
        val secondFragmentTransaction = secondFragmentManager.beginTransaction()

        val secondFragment = SecondFragment()

        val bundle = Bundle()
        bundle.putInt("position", position)
        secondFragment.arguments = bundle

        secondFragmentTransaction.add(R.id.secondFrame, secondFragment)

        secondFragmentTransaction.commit()

    }
}