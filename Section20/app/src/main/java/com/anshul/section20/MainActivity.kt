package com.anshul.section20



import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    lateinit var buttonReplace : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val firstFragmentManager : FragmentManager = supportFragmentManager
        val firstFragmentTransection : FragmentTransaction = firstFragmentManager.beginTransaction()

        val firstFragment = first_fragment()

        firstFragmentTransection.add(R.id.frame, firstFragment)

        firstFragmentTransection.commit()

        // For Second Fragment
        buttonReplace = findViewById(R.id.replaceButton)

        buttonReplace.setOnClickListener {
            val secondFragmentManager : FragmentManager = supportFragmentManager
            val secondFragmentTransection : FragmentTransaction = secondFragmentManager.beginTransaction()

            val secondFragment = SecondFragment()

            secondFragmentTransection.replace(R.id.frame, secondFragment)

            secondFragmentTransection.addToBackStack(null)

            secondFragmentTransection.commit()


        }



    }
}