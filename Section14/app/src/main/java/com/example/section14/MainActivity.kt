package com.example.section14

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var userName: EditText
    private lateinit var userMessage: EditText
    private lateinit var counter: Button
    private lateinit var remember: CheckBox

    private var count: Int = 0

    private lateinit var sharedPreferences: SharedPreferences

    private var name: String? = null
    private var message: String? = null
    private var isCheck: Boolean? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        userName = findViewById(R.id.editTextName)
        userMessage = findViewById(R.id.editTextMessage)
        counter = findViewById(R.id.button)
        remember = findViewById(R.id.checkBox)

        counter.setOnClickListener {
            count++
            counter.text = "" + count

        }


    }

    override fun onPause() {
        super.onPause()

        saveData()
    }

    fun saveData() {

        sharedPreferences = getSharedPreferences("saveData", MODE_PRIVATE)

        name = userName.text.toString()
        message = userMessage.text.toString()
        isCheck = remember.isChecked

        val editor = sharedPreferences.edit()

        editor.putString("key name", name)
        editor.putString("key message", message)
        editor.putInt("key count", count)
        editor.putBoolean("key remember", isCheck!!)

        editor.apply()

        Toast.makeText(applicationContext, "Data Saved", Toast.LENGTH_SHORT).show()

    }



    fun retrieve(){

        sharedPreferences = getSharedPreferences("saveData", MODE_PRIVATE)

        name = sharedPreferences.getString("key name",null)
        message = sharedPreferences.getString("key message",null)
        count = sharedPreferences.getInt("key count",0)
        isCheck = sharedPreferences.getBoolean("key remember",false)

        userName.setText(name)
        userMessage.setText(message)
        counter.text = "" + count
        remember.isChecked = isCheck!!

    }

    override fun onResume() {
        super.onResume()
        retrieve()
    }

}