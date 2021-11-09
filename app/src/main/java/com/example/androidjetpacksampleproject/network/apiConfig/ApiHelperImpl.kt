package com.example.androidjetpacksampleproject.network.apiConfig

import com.example.androidjetpacksampleproject.data.model.Users
import retrofit2.Response
import javax.inject.Inject

/**
 * @author Atik Faysal(Android Developer)
 * @Email mdatikfaysal@gmail.com
 * @Created 11/9/2021 at 1:54 PM
 */
class ApiHelperImpl @Inject constructor(private val apiService : ApiServices) : ApiHelper
{
    override suspend fun getUsers(): Response<List<Users>> = apiService.getUsers()
}