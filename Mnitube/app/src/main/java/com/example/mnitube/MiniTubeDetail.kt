package com.example.mnitube

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_mini_tube_detail.*

class MiniTubeDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mini_tube_detail)

        val url = intent.getStringExtra("video_url")

        val mediaCon = MediaController(this)
        video_view.setVideoPath(url)
        video_view.requestFocus()
        video_view.start()
        mediaCon.show()
    }
}
