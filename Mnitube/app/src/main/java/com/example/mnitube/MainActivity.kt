package com.example.mnitube

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var glide: RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MasterApp).service.getYouTubeList()
            .enqueue(object : Callback<Array<YouTube>> {
                override fun onFailure(call: Call<Array<YouTube>>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<Array<YouTube>>,
                    response: Response<Array<YouTube>>
                ) {
                    if(response.isSuccessful){
                        glide = Glide.with(this@MainActivity)
                        val youtubeList = response.body()
                        val adapter = tubeAdapter(
                            youtubeList!!,
                            LayoutInflater.from(this@MainActivity),
                            glide,
                            this@MainActivity
                        )
                        recycler_view.adapter = adapter
                    }
                }
            })
    }
}

class tubeAdapter(
    val itemList: Array<YouTube>,
    val inflater: LayoutInflater,
    val glide: RequestManager,
    val activity: Activity
) : RecyclerView.Adapter<tubeAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView
        val thumbnail: ImageView
        val content: TextView

        init {
            title = itemView.findViewById(R.id.tube_title)
            thumbnail = itemView.findViewById(R.id.tube_thumbnail)
            content = itemView.findViewById(R.id.tube_content)

            itemView.setOnClickListener {
                val position = adapterPosition
                val intent = Intent(activity, MiniTubeDetail::class.java)
                intent.putExtra("video_url", itemList.get(position).video)
                activity.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = inflater.inflate(R.layout.tube_item_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.setText(itemList.get(position).title)
        holder.content.setText(itemList.get(position).content)
        glide.load(itemList.get(position).thumbnail).into(holder.thumbnail)
    }
}