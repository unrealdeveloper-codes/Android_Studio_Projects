package com.anshul.firstfirebaseproject

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.anshul.firstfirebaseproject.databinding.ActivityUpdateUserBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class UpdateUserActivity : AppCompatActivity() {

    lateinit var updateUserBinding : ActivityUpdateUserBinding

    val database : FirebaseDatabase = FirebaseDatabase.getInstance()
    val myReference : DatabaseReference = database.reference.child("MyUsers")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        updateUserBinding = ActivityUpdateUserBinding.inflate(layoutInflater)
        setContentView(updateUserBinding.root)

        supportActionBar?.title = "Update User"

        getAndSetData()

        updateUserBinding.buttonUpdateUser.setOnClickListener {

            updateData()

        }

    }
    fun getAndSetData(){

        val name = intent.getStringExtra("name")
        val age = intent.getIntExtra("age",0).toString()
        val email = intent.getStringExtra("email")

        updateUserBinding.editTextUpdateName.setText(name)
        updateUserBinding.editTextUpdateAge.setText(age)
        updateUserBinding.editTextUpdateEmail.setText(email)

    }

    fun updateData(){

        val updateName = updateUserBinding.editTextUpdateName.text.toString()
        val updateAge = updateUserBinding.editTextUpdateAge.text.toString().toInt()
        val updateEmail = updateUserBinding.editTextUpdateEmail.text.toString()
        val userId = intent.getStringExtra("id").toString()

        val userMap = mutableMapOf<String,Any>()
        userMap["userId"] = userId
        userMap["name"] = updateName
        userMap["age"] = updateAge
        userMap["email"] = updateEmail

        myReference.child(userId).updateChildren(userMap).addOnCompleteListener { task ->
            if (task.isSuccessful){

                Toast.makeText(applicationContext,"The user has been updated successfully",Toast.LENGTH_SHORT).show()
                finish()
            }
        }

    }

}