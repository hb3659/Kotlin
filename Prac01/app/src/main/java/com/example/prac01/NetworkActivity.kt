package com.example.prac01

import android.os.AsyncTask
import android.os.AsyncTask.execute
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLConnection
import javax.net.ssl.HttpsURLConnection

class NetworkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)

        NetworkAsync().execute()
    }
}

class NetworkAsync() : AsyncTask<Any?, Any?, Any?>() {
    override fun doInBackground(vararg params: Any?): Any? {
        val urlString = "http://mellowcode.org/json/students/"
        val url: URL = URL(urlString)
        val connection: HttpURLConnection =
            url.openConnection() as HttpURLConnection

        connection.requestMethod = "GET"
        connection.setRequestProperty("Connection-Type", "application/json")

        var buffer = ""

        if (connection.responseCode == HttpsURLConnection.HTTP_OK) {
            Log.d("connn", "inputStream : "+connection.inputStream)

            val reader = BufferedReader(
                InputStreamReader(
                    connection.inputStream,
                    "UTF-8"
                )
            )
            buffer = reader.readLine()
            Log.d("connn", "buffer : "+buffer)
        }

        val data = Gson().fromJson(buffer, Array<PersonFromServer>::class.java)
        val age = data[0].age

        Log.d("connn","age : "+ age)

        return null
    }
}

