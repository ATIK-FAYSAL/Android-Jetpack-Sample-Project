package com.example.androidjetpacksampleproject.network.apiConfig

import com.example.androidjetpacksampleproject.data.model.Users
import retrofit2.Response
import retrofit2.http.GET

/**
 * @author Atik Faysal(Android Developer)
 * @Email mdatikfaysal@gmail.com
 * @Created 11/9/2021 at 1:54 PM
 */
interface ApiServices
{
    @GET("users")
    suspend fun getUsers(): Response<List<Users>>
}