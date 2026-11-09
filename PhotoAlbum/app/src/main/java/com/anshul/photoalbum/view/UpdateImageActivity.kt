package com.anshul.photoalbum.view

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.anshul.photoalbum.databinding.UpdateImageActivityBinding
import com.anshul.photoalbum.model.MyImages
import com.anshul.photoalbum.util.ConvertImage
import com.anshul.photoalbum.viewmodel.MyImagesViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UpdateImageActivity : AppCompatActivity() {

    lateinit var updateImageBinding: UpdateImageActivityBinding
    var id = -1
    lateinit var viewMode: MyImagesViewModel
    var imageAsString = ""

    lateinit var activityResultLauncherForSelectImage : ActivityResultLauncher<Intent>
    lateinit var selectedImage : Bitmap
    var control = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        updateImageBinding = UpdateImageActivityBinding.inflate(layoutInflater)
        val view = updateImageBinding.root
        setContentView(view)

        viewMode = ViewModelProvider(this)[MyImagesViewModel::class.java]
        getAndSetTheData()

        registerActivityForSelectImage()

        updateImageBinding.imageViewUpdateimage.setOnClickListener {

            //access the images
            val intent = Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            //sta   rtActivityForResult ->Before API 30
            activityResultLauncherForSelectImage.launch(intent)

        }

        updateImageBinding.buttonUpdate.setOnClickListener {

            updateImageBinding.buttonUpdate.text = "Updating...Please wait"
            updateImageBinding.buttonUpdate.isEnabled = false

            lifecycleScope.launch (Dispatchers.IO){

                val updateTitle = updateImageBinding.editTextUpdateTitle.text.toString()
                val updateDescription = updateImageBinding.editTextUpdateDescription.text.toString()
                if (control){

                    val newImageAsString = ConvertImage.convertToaString(selectedImage)
                    if (newImageAsString != null){
                        imageAsString = newImageAsString
                    }else {
                        withContext(Dispatchers.Main) {
                            imageAsString = ""
                            Toast.makeText(application, "There is some problem, Please select an image", Toast.LENGTH_SHORT).show()
                        }
                    }

                }
                val myUpdatedImage = MyImages(updateTitle,updateDescription,imageAsString)
                myUpdatedImage.imageId = id
                viewMode.update(myUpdatedImage)
                finish()

            }

        }

         updateImageBinding.toolBarUpdateImage.setNavigationOnClickListener {
             finish()
         }

    }

    fun getAndSetTheData(){

        id = intent.getIntExtra("id",-1)

        if(id != -1){

            CoroutineScope(Dispatchers.IO).launch{

                val myImage = viewMode.getItemById(id)

                withContext(Dispatchers.Main){
                    updateImageBinding.editTextUpdateTitle.setText(myImage.imageTitle)
                    updateImageBinding.editTextUpdateDescription.setText(myImage.imageDescription)
                    imageAsString = myImage.imageAsString
                    val imageAsBitmap = ConvertImage.convertToBitmap(myImage.imageAsString)
                    updateImageBinding.imageViewUpdateimage.setImageBitmap(imageAsBitmap)
                }

            }

        }

    }

    fun registerActivityForSelectImage(){

        activityResultLauncherForSelectImage = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result->

            //result fo the intent
            val resultCode = result.resultCode
            val imageData = result.data

            if ( resultCode == RESULT_OK && imageData != null){

                val imageUri = imageData.data

                imageUri?.let{
                    selectedImage = if(Build.VERSION.SDK_INT >= 28){

                        val imageSource = ImageDecoder.createSource(this.contentResolver,it)
                        ImageDecoder.decodeBitmap(imageSource)
                    }else{
                        MediaStore.Images.Media.getBitmap(this.contentResolver,it)
                    }
                    updateImageBinding.imageViewUpdateimage.setImageBitmap(selectedImage)
                    control = true
                }

            }
        }

    }
}




