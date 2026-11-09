package com.anshul.photoalbum.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.anshul.photoalbum.model.MyImages
import com.anshul.photoalbum.room.MyImageDao
import com.anshul.photoalbum.room.MyImagesDatabase

class MyImagesRepository(application: Application) {

    var myImageDao : MyImageDao
    var imagesList : LiveData<List<MyImages>>

    init {
        val database = MyImagesDatabase.getDatabaseInstance(application)
        myImageDao = database.getMyImageDao()
        imagesList = myImageDao.getAllImages()
    }

    suspend fun insert(myImages: MyImages) {
        myImageDao.insert(myImages)
    }

    suspend fun delete(myImages: MyImages) {
        myImageDao.delete(myImages)
    }

    suspend fun update(myImages: MyImages) {
        myImageDao.update(myImages)
    }

    fun getAllImages() : LiveData<List<MyImages>> {
        return imagesList
    }

    suspend fun getItemById(id: Int): MyImages {
        return myImageDao.getItemById(id)
    }


}


