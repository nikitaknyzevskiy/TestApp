package com.nikita.testapp.screens.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nikita.testapp.db.model.UserModel.UserModel
import com.nikita.testapp.repository.UserRepository

class UserViewModel : ViewModel() {

    private val userRepository = UserRepository()

    private var userLiveData: LiveData<UserModel>? = null

    fun getUser(id: String): LiveData<UserModel> {
        if (userLiveData == null)
            userLiveData = userRepository.userLive(id)

        return userLiveData!!
    }

}