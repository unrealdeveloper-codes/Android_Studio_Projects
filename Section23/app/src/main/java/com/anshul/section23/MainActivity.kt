package com.anshul.section23

import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {

    lateinit var message: EditText
    lateinit var phoneNumber: EditText
    lateinit var send: Button

    var userMsg: String? = ""
    var userPhone: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        message = findViewById(R.id.message)
        phoneNumber = findViewById(R.id.PhoneNumber)
        send = findViewById(R.id.send)

        send.setOnClickListener {

            userMsg = message.text.toString()
            userPhone = phoneNumber.text.toString()

            sendMessage(userMsg.toString(), userPhone.toString())
        }

    }

    fun sendMessage(userMsg: String, userPhone: String) {

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.SEND_SMS)
            != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.SEND_SMS), 1)

        }else{
            val smsManager : SmsManager

            if(Build.VERSION.SDK_INT >= 23){
                smsManager = this.getSystemService(SmsManager::class.java)
            }else{
                smsManager = SmsManager.getDefault()
            }

            smsManager.sendTextMessage(userPhone, null, userMsg, null, null)
            Toast.makeText(this,"Message Send", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String?>,
        grantResults: IntArray,
        deviceId: Int
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults, deviceId)

        if (requestCode == 1 && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            val smsManager : SmsManager

            if(Build.VERSION.SDK_INT >= 23){
                smsManager = this.getSystemService(SmsManager::class.java)
            }else{
                smsManager = SmsManager.getDefault()
            }

            smsManager.sendTextMessage(userPhone, null, userMsg, null, null)

            Toast.makeText(this,"Message Send", Toast.LENGTH_SHORT).show()

        }
    }




}