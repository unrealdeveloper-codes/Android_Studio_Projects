package com.anshul.photoalbum.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.anshul.photoalbum.model.MyImages

@Dao
interface MyImageDao {

    @Insert
    suspend fun insert(myImage: MyImages)

    @Update
    suspend fun update(myImage: MyImages)

    @Delete
    suspend fun delete(myImage: MyImages)

    @Query("SELECT * FROM my_images ORDER BY imageId ASC")
    fun getAllImages(): LiveData<List<MyImages>>

    @Query("SELECT * FROM my_images WHERE imageId = :id")
    suspend fun getItemById(id: Int): MyImages
}