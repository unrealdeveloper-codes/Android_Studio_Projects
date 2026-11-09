package com.anshul.firstfirebaseproject

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.anshul.firstfirebaseproject.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    lateinit var loginBinding: ActivityLoginBinding

    val auth : FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)

        loginBinding.loginSignIn.setOnClickListener {

            val email = loginBinding.editTextLoginEmail.text.toString()
            val password = loginBinding.editTextLoginPassword.text.toString()

            signInWithEmailAndPassword(email, password)

        }

        loginBinding.loginsignup.setOnClickListener {

            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)

        }

        loginBinding.forgotPassword.setOnClickListener {

            val intent = Intent(this, ForgotPasswordAcativity::class.java)
            startActivity(intent)

        }

        loginBinding.verifyWithPhoneNumber.setOnClickListener {

            val intent = Intent(this, PhoneVerificationActivity::class.java)
            startActivity(intent)

        }

    }
    fun signInWithEmailAndPassword(email : String, password : String){

        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->

            if (task.isSuccessful){

                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()

            }else{

                Toast.makeText(this, task.exception?.localizedMessage, Toast.LENGTH_SHORT).show()

            }
        }
    }

    override fun onStart() {
        super.onStart()

        val user = auth.currentUser
        if (user != null){

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}