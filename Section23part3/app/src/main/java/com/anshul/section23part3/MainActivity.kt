package com.anshul.section23part3

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import android.Manifest

class MainActivity : AppCompatActivity() {

    lateinit var phone : EditText
    lateinit var call : Button

    var userNumber : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        phone = findViewById(R.id.phonenumber)
        call = findViewById(R.id.call)

        call.setOnClickListener {

            userNumber = phone.text.toString()

            sendCall(userNumber)

        }

    }

    fun sendCall(userNumber: String) {

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
            != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE),100)

        }else{
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:$userNumber")
            startActivity(intent)
        }


    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String?>,
        grantResults: IntArray,
        deviceId: Int
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults, deviceId)

        if (requestCode == 100 && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            val intent = Intent(Intent.ACTION_CALL)
            intent.data = "tel:$userNumber".toUri()
            startActivity(intent)

        }

    }
}