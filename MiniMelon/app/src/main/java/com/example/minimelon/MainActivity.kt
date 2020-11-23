package com.example.minimelon

import android.app.Activity
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isInvisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var player: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MasterApp).service.getSongList().enqueue(
            object : Callback<Array<Song>> {
                override fun onFailure(call: Call<Array<Song>>, t: Throwable) {

                }

                override fun onResponse(call: Call<Array<Song>>, response: Response<Array<Song>>) {
                    if (response.isSuccessful) {
                        val songList = response.body()
                        val adapter = SongAdapter(
                            songList!!,
                            LayoutInflater.from(this@MainActivity),
                            Glide.with(this@MainActivity),
                            this@MainActivity
                        )
                        recycler_view.adapter = adapter
                    }
                }
            }
        )
    }

//    override fun onPause() {
//        player?.stop()
//        player?.release()
//        super.onPause()
//    }

    inner class SongAdapter(
        val itemList: Array<Song>,
        val inflater: LayoutInflater,
        val glide: RequestManager,
        val activity: Activity
    ) : RecyclerView.Adapter<SongAdapter.ViewHolder>() {

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val title: TextView
            val song: ImageView
            val play: ImageView
            val pause: ImageView

            init {
                title = itemView.findViewById(R.id.mel_song_title)
                song = itemView.findViewById(R.id.mel_song_img)
                play = itemView.findViewById(R.id.mel_play)
                pause = itemView.findViewById(R.id.mel_pause)

                play.setOnClickListener {
                    try {
                        val position: Int = adapterPosition
                        val path = itemList.get(position).song

                        player?.stop()
                        player?.release()
                        player = null
                        player = MediaPlayer.create(
                            this@MainActivity,
                            Uri.parse(path)
                        )
                        player?.start()

                        play.visibility = View.INVISIBLE
                        pause.visibility = View.VISIBLE

                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
                pause.setOnClickListener {
                    player?.pause()
                    pause.visibility = View.INVISIBLE
                    play.visibility = View.VISIBLE
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = inflater.inflate(R.layout.song_item_view, parent, false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int {
            return itemList.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.title.setText(itemList.get(position).title)
            glide.load(itemList.get(position).thumbnail).into(holder.song)
        }
    }
}

