package com.anshu.section14

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat



class MainActivity : AppCompatActivity() {

    //sharedPreference class to store data
    lateinit var username: String
    lateinit var usermessage: String
    lateinit var counter: Button
    lateinit var remember: CheckBox
    var count : Int = 0

    var name : String? = null
    var message : String? = null
    var isCheck : Boolean? = null

    lateinit var sharedPreference: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        username = findViewById(R.id.editTextName)
        usermessage = findViewById(R.id.editTextMessage)
        counter = findViewById(R.id.submit)
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

    fun saveData(){
        sharedPreference = this.getSharedPreferences("saveData", MODE_PRIVATE)

        name = username.text.toString()
        message = usermessage.text.toString()
        isCheck = remember.isChecked

        val editor = sharedPreference.edit()

        editor.putString("key name ",name)
        editor.putString("key message",message)
        editor.putInt("key count",count)
        editor.putBoolean("key remember",isCheck!!)

        editor.apply()

        Toast.makeText(applicationContext,"Your data is saved",Toast.LENGTH_SHORT).show()
    }

}