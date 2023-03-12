package com.example.restpost

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface apiInterface {
    @POST("posts")
    fun sendUserData(
        @Body
        userPost:UserPost
    ): Call<UserPost>
}