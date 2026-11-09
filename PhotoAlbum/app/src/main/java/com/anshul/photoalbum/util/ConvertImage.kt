package com.anshul.photoalbum.util

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.ByteArrayOutputStream
import android.util.Base64
import androidx.core.graphics.scale

class ConvertImage {

    companion object{

        fun convertToaString(bitmap: Bitmap) : String? {

            val stream = ByteArrayOutputStream()
            val resultCompress = bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)

            if(resultCompress){
                val byteArray = stream.toByteArray()
                val imageAsString = if (byteArray.size > 2000000){
                    resizeImage(bitmap,0.1)
                }else if(byteArray.size in 1_000_000..2_000_000){
                    resizeImage(bitmap,0.5)
                }else{
                    Base64.encodeToString(byteArray, Base64.DEFAULT)
                }

                return imageAsString

            }else{
                return null
            }

        }


        fun resizeImage(bitmap: Bitmap, coefficient : Double) : String? {

            val resizedBitmap = bitmap.scale((bitmap.width * coefficient).toInt(), (bitmap.height * coefficient).toInt(), true)

            val newStream = ByteArrayOutputStream()
            val resultCompress = resizedBitmap.compress(Bitmap.CompressFormat.JPEG,100,newStream)

            if(resultCompress){
                val newByteArray = newStream.toByteArray()
                return Base64.encodeToString(newByteArray, Base64.DEFAULT)
            }else {
                return null
            }
        }

        fun convertToBitmap(imageAsString: String) : Bitmap?{

            return try {
                val byteArray = Base64.decode(imageAsString, Base64.DEFAULT)
                BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
            } catch (e: IllegalArgumentException) {
                e.printStackTrace()
                null
            }
        }
    }
}