package com.nikita.testapp.repository

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.nikita.testapp.db.DataBaseBuilder
import com.nikita.testapp.db.convector.UserConvector
import com.nikita.testapp.db.dao.UserDao
import com.nikita.testapp.db.model.UserModel.UserModel
import com.nikita.testapp.rest.RestBuilder
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class UserRepository {

    private val rest = RestBuilder.rest

    private val userDao: UserDao by lazy {
        DataBaseBuilder.db.userDao()
    }


    fun userListPaged(): LiveData<PagedList<UserModel>> {

        runBlocking {
            load()
        }

        return userDao.usersPaged().toLiveData(10)
    }

    private suspend fun load() = withContext(Dispatchers.IO + errorHandler) {
        val userList = rest.userList().results

        val userModels = UserConvector.convert(userList)

        userDao.save(userModels)
    }

    private val errorHandler = CoroutineExceptionHandler { error, context ->
        //TODO(Implement errors)
    }

}

fun <MODEL> DataSource.Factory<Int, MODEL>
        .toLiveData(pageSize: Int): LiveData<PagedList<MODEL>> {
    return LivePagedListBuilder(
        this, pageSize).build()
}