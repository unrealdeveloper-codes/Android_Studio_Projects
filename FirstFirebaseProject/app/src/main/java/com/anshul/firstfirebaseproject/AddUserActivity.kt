package com.anshul.firstfirebaseproject

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.anshul.firstfirebaseproject.databinding.ActivityAddUserBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddUserActivity : AppCompatActivity() {

    lateinit var addUserBinding: ActivityAddUserBinding

    val database : FirebaseDatabase = FirebaseDatabase.getInstance()
    val myReference : DatabaseReference = database.reference.child("MyUsers")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        addUserBinding = ActivityAddUserBinding.inflate(layoutInflater)
        setContentView(addUserBinding.root)

        addUserBinding.buttonAddUser.setOnClickListener {

            addUsersToDatabase()


        }

    }

    fun addUsersToDatabase(){
        val name : String = addUserBinding.editTextName.text.toString()
        val age : Int = addUserBinding.editTextAge.text.toString().toInt()
        val email : String = addUserBinding.editTextEmail.text.toString()

        val id : String = myReference.push().key.toString()

        val user = Users(id, name, age, email)

        myReference.child(id).setValue(user).addOnCompleteListener { task ->

            if (task.isSuccessful){

                Toast.makeText(applicationContext, "New User have been added to database", Toast.LENGTH_SHORT).show()
                finish()

            }else{
                Toast.makeText(applicationContext, task.exception.toString(), Toast.LENGTH_SHORT).show()
            }
        }



    }


}