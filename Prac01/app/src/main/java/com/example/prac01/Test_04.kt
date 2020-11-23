package com.example.prac01

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_test04.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLConnection

class Test04 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test04)

        AsyncTest(
            recycler,
            LayoutInflater.from(this)
        ).execute()
    }
}

class AsyncTest(
    val recyclerView: RecyclerView,
    val inflater: LayoutInflater
) : AsyncTask<Any?, Any?, Array<PersonFromServer>>() {
    // UI 에 접근 가능
    override fun onPostExecute(result: Array<PersonFromServer>?) {
        val adapter = RecycleAdapter(result!!, inflater)
        recyclerView.adapter = adapter
    }

    // UI 에 접근 불가능
    override fun doInBackground(vararg params: Any?): Array<PersonFromServer>? {
        val urlString = "http://mellowcode.org/json/students/"
        val url: URL = URL(urlString)
        val connection: HttpURLConnection =
            url.openConnection() as HttpURLConnection

        connection.requestMethod = "GET"
        connection.setRequestProperty("connection-Type", "application/json")

        var buffer = ""

        if (connection.responseCode == HttpURLConnection.HTTP_OK) {
            val reader = BufferedReader(
                InputStreamReader(
                    connection.inputStream,
                    "UTF-8"
                )
            )
            buffer = reader.readLine()
        }
        val data = Gson().fromJson(buffer, Array<PersonFromServer>::class.java)

        return data
    }
}

class RecycleAdapter(
    val personList: Array<PersonFromServer>,
    val inflater: LayoutInflater
) : RecyclerView.Adapter<RecycleAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView
        val id: TextView
        val age: TextView
        val intro: TextView

        init {
            name = itemView.findViewById(R.id.name)
            id = itemView.findViewById(R.id.identification)
            age = itemView.findViewById(R.id.age)
            intro = itemView.findViewById(R.id.intro)
        }
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.activity_test04_01, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.setText(personList.get(position).name ?: "")
        holder.id.setText(personList.get(position).id.toString())
        holder.age.setText(personList.get(position).age.toString())
        holder.intro.setText(personList.get(position).intro ?: "")
    }
}
