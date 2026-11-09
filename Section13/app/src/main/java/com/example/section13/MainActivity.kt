package com.example.section13

import android.app.Activity
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.JobIntentService
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.section13.databinding.AndroidbindingBinding


class MainActivity : AppCompatActivity() {


    //Intent
    lateinit var name : EditText
    lateinit var age : EditText
    lateinit var submit : Button

//    //service
//    lateinit var startClassicService : Button
//    lateinit var startJobIntentService : Button
//    lateinit var stopService : Button

//    //broadcast
//    var broad = BroadcastExample()

//    //Binding
//    lateinit var mainBinding : AndroidbindingBinding // xmlfilename + Binding (class)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

//        mainBinding = AndroidbindingBinding.inflate(layoutInflater)
//        val view = mainBinding.root
//
//        setContentView(view)
//
//        mainBinding.submit.setOnClickListener {
//            mainBinding.result.text = mainBinding.edittextname.text.toString()
//        }



//        //Broadcast
//        setContentView(R.layout.broadcast)
//
//        val filter = IntentFilter()
//        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
//        registerReceiver(broad, filter)



//        //Service
//        setContentView(R.layout.service)
//
//        startClassicService = findViewById(R.id.classicService)
//        startJobIntentService = findViewById(R.id.jobIntentService)
//        stopService = findViewById(R.id.stopService)
//
//        startClassicService.setOnClickListener {
//            val intent = Intent(this@MainActivity, ClassicServiceExample::class.java)
//            startService(intent)
//
//        }
//
//        startJobIntentService.setOnClickListener {
//            val intent = Intent(this@MainActivity, JobIntentServiceExample::class.java)
//            JobIntentServiceExample.myBackgroundService(this@MainActivity, intent)
//            startService(intent)
//        }
//
//        stopService.setOnClickListener {
//
//            val intent = Intent(this@MainActivity, ClassicServiceExample::class.java)
//            stopService(intent)
//        }


        //Intent
        setContentView(R.layout.intent)

        name = findViewById(R.id.editTextName)
        age = findViewById(R.id.editTextNum)
        submit = findViewById(R.id.submitButton)

        submit.setOnClickListener {

            var userName : String = name.text.toString()
            var userAge : Int = age.text.toString().toInt()

            val intent = Intent(this@MainActivity, SecondaryActivity::class.java)

            intent.putExtra("user name", userName)
            intent.putExtra("user age", userAge)

            startActivity(intent)
        }


    }

//    //broadcast
//    override fun onStart() {
//        super.onStart()
//        val filter = IntentFilter()
//        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
//        registerReceiver(broad, filter)
//    }
//
//    override fun onStop() {
//        super.onStop()
//        val filter = IntentFilter()
//        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
//        unregisterReceiver(broad)
//    }



}