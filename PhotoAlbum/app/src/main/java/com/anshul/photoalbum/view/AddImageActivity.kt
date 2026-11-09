package com.anshul.photoalbum.view

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
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
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.anshul.photoalbum.databinding.ActivityAddImageBinding
import com.anshul.photoalbum.model.MyImages
import com.anshul.photoalbum.util.ControlPermission
import com.anshul.photoalbum.util.ConvertImage
import com.anshul.photoalbum.viewmodel.MyImagesViewModel
import kotlinx.coroutines.launch

class AddImageActivity : AppCompatActivity() {

    lateinit var addImageBinding: ActivityAddImageBinding
    lateinit var activityResultLauncherForSelectImage : ActivityResultLauncher<Intent>
    lateinit var selectedImage : Bitmap
    lateinit var myImagesViewModel: MyImagesViewModel
    var control = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        addImageBinding = ActivityAddImageBinding.inflate(layoutInflater)
        val view = addImageBinding.root
        setContentView(view)

        myImagesViewModel = ViewModelProvider(this)[MyImagesViewModel::class.java]

        registerActivityForSelectImage()

        addImageBinding.imageViewaddimage.setOnClickListener {

            if(ControlPermission.checkPermission(this)){
                //access the images
                val intent = Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                //start ActivityForResult -> Before API 30
                activityResultLauncherForSelectImage.launch(intent)

            }else{
                if(Build.VERSION.SDK_INT >= 33){
                    ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_MEDIA_IMAGES), 1)
                }else{
                    ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 1)
                }
            }

        }

        addImageBinding.buttonAdd.setOnClickListener {

            if(control){

                addImageBinding.buttonAdd.text = "Uploading...Please wait"
                addImageBinding.buttonAdd.isEnabled = false

                lifecycleScope.launch {

                    val title = addImageBinding.editTextTitle.text.toString()
                    val description = addImageBinding.editTextDescription.text.toString()

                    val imageAsString = ConvertImage.convertToaString(selectedImage)

                    if (imageAsString != null){
                        myImagesViewModel.insert(MyImages(title,description,imageAsString))
                        control = false
                        finish()
                    }else{
                        Toast.makeText(application,"There is some problem, Please select an image", Toast.LENGTH_SHORT).show()
                    }
                }

            }else{
                Toast.makeText(application,"Please select an image", Toast.LENGTH_SHORT).show()
            }

        }

        addImageBinding.toolBarAddImage.setNavigationOnClickListener {
            finish()
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
                    addImageBinding.imageViewaddimage.setImageBitmap(selectedImage)
                    control = true
                }

            }
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode == 1 && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            //access the images
            val intent = Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            //startActivityForResult ->Before API 30
            activityResultLauncherForSelectImage.launch(intent)

        }
    }
}