package com.nikita.testapp.db.dao

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.nikita.testapp.db.model.UserModel.UserModel

@Dao
interface UserDao {

    @Insert(onConflict = REPLACE)
    suspend fun save(data: List<UserModel>)

    @Query("select * from usermodel")
    fun usersPaged(): DataSource.Factory<Int, UserModel>

    @Query("select * from usermodel where id = :id limit 1")
    fun user(id: String): LiveData<UserModel>

}