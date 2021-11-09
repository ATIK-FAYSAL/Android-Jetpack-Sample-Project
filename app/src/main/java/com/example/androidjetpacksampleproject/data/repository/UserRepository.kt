package com.example.androidjetpacksampleproject.data.repository

import com.example.androidjetpacksampleproject.network.apiConfig.ApiHelper
import javax.inject.Inject

/**
 * @author Atik Faysal(Android Developer)
 * @Email mdatikfaysal@gmail.com
 * @Created 11/9/2021 at 12:55 PM
 */
class UserRepository @Inject constructor(private val apiHelper: ApiHelper)
{
    suspend fun getUsers() = apiHelper.getUsers()
}