package com.anshul.firstfirebaseproject


import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.anshul.firstfirebaseproject.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {

    lateinit var signUpBinding : ActivitySignUpBinding

    val auth : FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        signUpBinding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(signUpBinding.root)


        signUpBinding.SignUpButton.setOnClickListener {

            val userEmail = signUpBinding.editTextSignupEmail.text.toString()
            val userPassword = signUpBinding.editTextSignupPassword.text.toString()

            signUpWithFirebase(userEmail, userPassword)

        }

    }

    fun signUpWithFirebase(userEmail : String, userPassword : String){

        auth.createUserWithEmailAndPassword(userEmail,userPassword).addOnCompleteListener { task ->
            if (task.isSuccessful){

                Toast.makeText(applicationContext,"Your account has been created",Toast.LENGTH_SHORT).show()
                finish()

            } else{
                Toast.makeText(applicationContext,task.exception?.localizedMessage,Toast.LENGTH_SHORT).show()
            }
        }

    }
}