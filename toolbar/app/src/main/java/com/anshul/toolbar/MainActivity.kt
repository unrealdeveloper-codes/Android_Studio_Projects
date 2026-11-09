package com.anshul.toolbar

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    //tool bar
//    lateinit var toolbar : MaterialToolbar

    //toast message
    lateinit var message : Button



//    //snack bar
//    lateinit var snackmessage : Button
//    lateinit var layout : ConstraintLayout


//    //dialog box
//    lateinit var dialogbox: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()



//        //dialog box
//        setContentView(R.layout.dialogbox)
//
//        dialogbox = findViewById(R.id.dialogboxbutton)
//
//        dialogbox.setOnClickListener {
//            showAlertDialog()
//        }



        //Snack bar
//        setContentView(R.layout.snackbar)
//
//        snackmessage = findViewById(R.id.buttonsnack)
//        layout = findViewById(R.id.mylayout)
//
//        snackmessage.setOnClickListener {
//
//            Snackbar.make(layout,"This is a SnackBar", Snackbar.LENGTH_INDEFINITE)
//                .setAction("Close") {
//
//                }.show()
//        }

        // Toast mesage
        setContentView(R.layout.toastmessage)

        message = findViewById(R.id.toast)

        message.setOnClickListener {
            Toast.makeText(applicationContext,"Toast message is clicked", Toast.LENGTH_LONG).show()
        }

//        setContentView(R.layout.toolbar)
//
//        toolbar = findViewById(R.id.materialbar)
//
//        toolbar.overflowIcon = AppCompatResources.getDrawable(this,R.drawable.baseline_more_vert_24)
//
//        toolbar.setNavigationOnClickListener {
//            Toast.makeText(applicationContext,"Navigation icon is clicked", Toast.LENGTH_SHORT).show()
//
//        }
//
//        toolbar.setOnMenuItemClickListener { items->
//
//            when(items.itemId){
//
//                R.id.shareicon -> Toast.makeText(applicationContext,"Share icon is clicked", Toast.LENGTH_SHORT).show()
//                R.id.editicon -> Toast.makeText(applicationContext,"Edit icon is clicked", Toast.LENGTH_SHORT).show()
//                R.id.setting -> Toast.makeText(applicationContext,"Setting icon is clicked", Toast.LENGTH_SHORT).show()
//                else -> Toast.makeText(applicationContext,"Share icon is clicked", Toast.LENGTH_SHORT).show()
//            }
//
//            return@setOnMenuItemClickListener true
//        }


//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
//    fun showAlertDialog() {
//        val alertDialog = AlertDialog.Builder(this@MainActivity)
//        alertDialog.setTitle("Change")
//            .setMessage("Do you want to change the text of the button")
//            .setIcon(R.drawable.baseline_warning_24)
//            .setCancelable(false)
//            .setNegativeButton("NO", DialogInterface.OnClickListener { dialogInterface, which ->
//                dialogInterface.cancel()
//            })
//            .setPositiveButton("YES", DialogInterface.OnClickListener { dialogInterface, which ->
//                dialogbox.text = "Alert Dialog"
//
//            })
//        alertDialog.create().show()
//    }

}
