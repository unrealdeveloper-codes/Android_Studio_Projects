package com.anshul.photoalbum.view

import android.content.Intent
import android.os.Bundle

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anshul.photoalbum.adapter.MyImagesAdapter
import com.anshul.photoalbum.databinding.ActivityMainBinding
import com.anshul.photoalbum.viewmodel.MyImagesViewModel

class MainActivity : AppCompatActivity() {

    lateinit var  myImagesViewModel: MyImagesViewModel
    lateinit var mainBinding: ActivityMainBinding
    lateinit var myImagesAdapter: MyImagesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        myImagesViewModel = ViewModelProvider(this)[MyImagesViewModel::class.java]

        mainBinding.recycleView.layoutManager = LinearLayoutManager(this)
        myImagesAdapter = MyImagesAdapter(this)
        mainBinding.recycleView.adapter = myImagesAdapter

        myImagesViewModel.getAllImages().observe(this) { images ->

            //update the UI
            myImagesAdapter.setImage(images)

        }

        mainBinding.flaatingActionButton.setOnClickListener {
            //open addimage activity
            val intent = Intent(this, AddImageActivity::class.java)
            startActivity(intent)


        }

        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {

                return TODO("Provide the return value")
            }

            override fun onSwiped(
                viewHolder: RecyclerView.ViewHolder,
                direction: Int
            ) {

                myImagesViewModel.delete(myImagesAdapter.returnItemAtGivenPosition(viewHolder.adapterPosition))
            }

        }).attachToRecyclerView(mainBinding.recycleView)

    }
}




