package com.example.mnitube

import android.app.Application
import android.content.Context
import com.facebook.stetho.Stetho
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MasterApp : Application() {

    lateinit var service: RetrofitService

    override fun onCreate() {
        super.onCreate()

        Stetho.initializeWithDefaults(this)

        createRetrofit()
    }

    fun createRetrofit() {
        val header = Interceptor {
            val original = it.request()

            if (CheckLogin() == true) {
                getUserToken()?.let {token ->
                    val request = original.newBuilder()
                        .header("Authorization", "token "+token)
                        .build()
                    it.proceed(request)
                }
            } else {
                it.proceed(original)
            }


        }

        val client = OkHttpClient.Builder()
            .addInterceptor(header)
            .addNetworkInterceptor(StethoInterceptor())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        service = retrofit.create(RetrofitService::class.java)
    }

    fun CheckLogin(): Boolean {
        val sharedPreferences =
            getSharedPreferences("Login", Context.MODE_PRIVATE)
        val token = sharedPreferences.getString("Login", "null")
        if (token != "null") return true
        else return false
    }

    fun getUserToken(): String? {
        val sharedPreference =
            getSharedPreferences("Login", Context.MODE_PRIVATE)
        val token = sharedPreference.getString("Login", "null")
        if(token == "null") return null
        else return token
    }
}