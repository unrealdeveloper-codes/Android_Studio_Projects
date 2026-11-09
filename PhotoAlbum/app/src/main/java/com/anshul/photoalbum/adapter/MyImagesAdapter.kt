package com.anshul.photoalbum.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anshul.photoalbum.databinding.ImageItemsBinding
import com.anshul.photoalbum.model.MyImages
import com.anshul.photoalbum.util.ConvertImage
import com.anshul.photoalbum.view.UpdateImageActivity

class MyImagesAdapter (val activity: Activity): RecyclerView.Adapter<MyImagesAdapter.MyImagesViewHolder>() {

    var imagesList = ArrayList<MyImages>()

    fun setImage(images: List<MyImages>){
        this.imagesList = images as ArrayList<MyImages>
        notifyDataSetChanged()
    }
    class MyImagesViewHolder (val itemsBinding: ImageItemsBinding): RecyclerView.ViewHolder(itemsBinding.root)



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyImagesViewHolder {

        val view = ImageItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyImagesViewHolder(view)

    }

    override fun onBindViewHolder(
        holder: MyImagesViewHolder,
        position: Int
    ) {
        val myImage = imagesList[position]
        with(holder){
            itemsBinding.textViewTitle.text = myImage.imageTitle
            itemsBinding.textViewDescription.text = myImage.imageDescription
            val imageAsBitmap = ConvertImage.convertToBitmap(myImage.imageAsString)
            itemsBinding.imageView.setImageBitmap(imageAsBitmap)

            itemsBinding.cardView.setOnClickListener {
                val intent = Intent(activity, UpdateImageActivity::class.java)
                intent.putExtra("id",myImage.imageId)
                activity.startActivity(intent)

            }

        }

    }

    override fun getItemCount(): Int {

        return imagesList.size
    }

    fun returnItemAtGivenPosition(position: Int) : MyImages{

        return imagesList[position]
    }
}



