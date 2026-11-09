package com.anshul.firstfirebaseproject

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.anshul.firstfirebaseproject.databinding.ActivityForgotPasswordAcativityBinding
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordAcativity : AppCompatActivity() {

    lateinit var forgotPasswordBinding: ActivityForgotPasswordAcativityBinding

    val auth : FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        forgotPasswordBinding = ActivityForgotPasswordAcativityBinding.inflate(layoutInflater)
        val view = forgotPasswordBinding.root
        setContentView(view)

        forgotPasswordBinding.resetPassword.setOnClickListener {

            val email = forgotPasswordBinding.editTextResetEmailPassword.text.toString()

            auth.sendPasswordResetEmail(email).addOnCompleteListener { task ->
                if (task.isSuccessful){

                    Toast.makeText(this,"Check your email for reset password",Toast.LENGTH_SHORT).show()
                    finish()
                    }
                else{
                    Toast.makeText(this,task.exception?.localizedMessage,Toast.LENGTH_SHORT).show()
                }
            }

        }

    }
}