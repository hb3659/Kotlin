package com.example.ministagram

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {
    @POST("user/signup/")
    @FormUrlEncoded
    fun register(
        @Field("username") username:String,
        @Field("password1") password1:String,
        @Field("password2") password2:String
    ):Call<User>

    @POST("user/login/")
    @FormUrlEncoded
    fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ):Call<User>

    @GET("instagram/post/list/all")
    fun getAllPosts():Call<Array<Post>>

    @Multipart
    @POST("instagram/post/")
    fun uploadPost(
        @Part image: MultipartBody.Part,
        @Part ("content")requestBody: RequestBody
    ):Call<Array<Post>>

    @GET("instagram/post/list/")
    fun getUserPostList():Call<Array<Post>>
}