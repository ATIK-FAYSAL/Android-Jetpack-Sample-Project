package com.example.androidjetpacksampleproject.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidjetpacksampleproject.data.repository.UserRepository
import com.example.androidjetpacksampleproject.ui.viewmodel.UserViewModel

class ViewModelFactory(private val repository: Any) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(repository as UserRepository) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}