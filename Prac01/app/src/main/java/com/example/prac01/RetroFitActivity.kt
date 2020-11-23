package com.example.prac01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_retro_fit.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.xml.parsers.FactoryConfigurationError

class RetroFitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retro_fit)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(RetrofitService::class.java)

        // GET 요청
        service.getStudentsList()
            .enqueue(object : Callback<ArrayList<PersonFromServer>> {
                override fun onFailure(call: Call<ArrayList<PersonFromServer>>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<ArrayList<PersonFromServer>>,
                    response: Response<ArrayList<PersonFromServer>>
                ) {
                    recycle.adapter = RecyclerAdapter(
                        response.body()!!,
                        LayoutInflater.from(this@RetroFitActivity)
                    )
                }
            })

        // POST 요청
//        val params = HashMap<String, Any>()
//        params.put("name", "Person 1")
//        params.put("age", "20")
//        params.put("id", "33")
//        params.put("intro", "Hello")
//        service.createStudent(params)
//            .enqueue(object : Callback<PersonFromServer> {
//                override fun onFailure(call: Call<PersonFromServer>, t: Throwable) {
//
//                }
//
//                override fun onResponse(
//                    call: Call<PersonFromServer>,
//                    response: Response<PersonFromServer>
//                ) {
//                    if (response.isSuccessful) {
//                        val person = response.body()
//                        Log.d("retrofitt", "name : "+person?.name)
//                    }
//                }
//            })

        // POST_2
//        val person = PersonFromServer(
//            name = "Person 2", age = 22, intro = "HI"
//        )
//        service.createStudentEasy(person).enqueue(
//            object : Callback<PersonFromServer> {
//                override fun onFailure(call: Call<PersonFromServer>, t: Throwable) {
//
//                }
//
//                override fun onResponse(
//                    call: Call<PersonFromServer>,
//                    response: Response<PersonFromServer>
//                ) {
//                    if (response.isSuccessful) {
//                        val person = response.body()
//                        Log.d("retrofitt", "name : " + person?.name)
//                    }
//                }
//            }
//        )
    }
}

class RecyclerAdapter(
    val personList: ArrayList<PersonFromServer>,
    val inflater: LayoutInflater
) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.activity_test04_01, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.setText(personList.get(position).name)
        holder.id.setText(personList.get(position).id.toString())
        holder.age.setText(personList.get(position).age.toString())
        holder.intro.setText(personList.get(position).intro)
    }
}
