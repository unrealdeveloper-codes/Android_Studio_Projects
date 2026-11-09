package com.anshul.firstfirebaseproject

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.anshul.firstfirebaseproject.databinding.ActivityPhoneVerificationBinding
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class PhoneVerificationActivity : AppCompatActivity() {

    lateinit var verifyBinding : ActivityPhoneVerificationBinding

    val auth : FirebaseAuth = FirebaseAuth.getInstance()

    lateinit var myCallbacks : PhoneAuthProvider.OnVerificationStateChangedCallbacks

    var verificationCode = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        verifyBinding = ActivityPhoneVerificationBinding.inflate(layoutInflater)
        val view = verifyBinding.root
        setContentView(view)

        myCallbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
            override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                signInWithPhoneAuthCredential(p0)
            }

            override fun onVerificationFailed(p0: FirebaseException) {
                Toast.makeText(this@PhoneVerificationActivity, "Verification Failed : ${p0.message}", Toast.LENGTH_SHORT).show()
            }

            override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken) {
                super.onCodeSent(p0, p1)

                verificationCode = p0
                Toast.makeText(this@PhoneVerificationActivity, "Verification Code Sent", Toast.LENGTH_SHORT).show()

            }

        }

        verifyBinding.Sendbutton.setOnClickListener {

            val input = verifyBinding.editTextPhoneNumber.text.toString().trim()

            if (input.length != 10) {
                Toast.makeText(this, "Enter a valid 10-digit phone number", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val phoneNumber = "+91$input"

            val options = PhoneAuthOptions.newBuilder(auth)
                .setPhoneNumber(phoneNumber)
                .setTimeout(60L,TimeUnit.SECONDS)
                .setCallbacks(myCallbacks)
                .setActivity(this)
                .build()

            PhoneAuthProvider.verifyPhoneNumber(options)

        }

        verifyBinding.VerificationButton.setOnClickListener {

            signInWithSMSCode()

        }


    }

    fun signInWithSMSCode(){

        val userEnteredCode = verifyBinding.editTextVerificationCode.text.toString()

        if (userEnteredCode.isEmpty()) {
            Toast.makeText(this, "Please enter the verification code", Toast.LENGTH_SHORT).show()
            return
        }

        val credential = PhoneAuthProvider.getCredential(verificationCode,userEnteredCode)

        signInWithPhoneAuthCredential(credential)

    }

    fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential){

        auth.signInWithCredential(credential).addOnCompleteListener { task ->

            if (task.isSuccessful){

                Toast.makeText(this, "Verification Successful", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()

            }else{
                Toast.makeText(this, " The code you entered is wrong", Toast.LENGTH_SHORT).show()
            }
        }
    }
}