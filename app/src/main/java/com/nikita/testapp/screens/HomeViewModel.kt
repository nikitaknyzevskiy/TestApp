package com.nikita.testapp.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.nikita.testapp.db.model.UserModel.UserModel
import com.nikita.testapp.repository.UserRepository

class HomeViewModel : ViewModel() {

    private val userRepository = UserRepository()

    private val usersList: LiveData<PagedList<UserModel>> by lazy {
        userRepository.userListPaged()
    }

}