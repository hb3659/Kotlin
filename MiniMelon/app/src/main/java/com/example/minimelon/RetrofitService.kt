package com.example.minimelon

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService{
    @GET("melon/list/")
    fun getSongList():Call<Array<Song>>
}