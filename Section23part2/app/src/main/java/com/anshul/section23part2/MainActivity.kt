package com.anshul.section23part2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Message
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.anshul.section23part2.databinding.ActivityMainBinding
import java.net.SocketAddress
import androidx.core.net.toUri

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        mainBinding.send.setOnClickListener {

            val userAddress = mainBinding.emailAddress.text.toString()
            val userSubject = mainBinding.subject.text.toString()
            val userMessage = mainBinding.message.text.toString()

            sendMail(userAddress,userSubject,userMessage)

        }

    }

    fun sendMail(userAddress : String,userSubject : String , userMessage : String){

        val emailAddress = arrayOf(userAddress)

        val emailIntent = Intent(Intent.ACTION_SENDTO)
        emailIntent.data = "mailto:".toUri()
//        val emailIntent = Intent(Intent.ACTION_SEND)
//        emailIntent.type = "*/*"
        emailIntent.putExtra(Intent.EXTRA_EMAIL,emailAddress)
        emailIntent.putExtra(Intent.EXTRA_TEXT,userMessage)
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,userSubject)

        if (emailIntent.resolveActivity(packageManager) != null){
            startActivity(Intent.createChooser(emailIntent,"Choose an app"))
        }

    }
}