package com.example.mnitube

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService{
    @GET("youtube/list/")
    fun getYouTubeList(): Call<Array<YouTube>>
}