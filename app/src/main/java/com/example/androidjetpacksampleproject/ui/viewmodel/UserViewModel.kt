package com.example.androidjetpacksampleproject.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidjetpacksampleproject.data.model.Users
import com.example.androidjetpacksampleproject.data.repository.UserRepository
import com.example.androidjetpacksampleproject.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author Atik Faysal(Android Developer)
 * @Email mdatikfaysal@gmail.com
 * Created 11/9/2021 at 11:53 AM
 */
@HiltViewModel
class UserViewModel @Inject constructor(
    private val  repository: UserRepository
    ) : ViewModel()
{
    private val _userList = MutableLiveData<Resource<List<Users>>>()
    val usersList : LiveData<Resource<List<Users>>>
        get() = _userList

    var isLoading = MutableLiveData(false)

    init {
        fetchUserList()
    }

    private fun fetchUserList()
    {
        viewModelScope.launch{
            isLoading.postValue(true)
            _userList.postValue(Resource.loading(null))
            repository.getUsers().let {
                if (it.isSuccessful) {
                    _userList.postValue(Resource.success(it.body()))
                } else _userList.postValue(Resource.error(it.errorBody().toString(), null))
            }
            isLoading.postValue(false)
        }
    }
}