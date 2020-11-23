package com.example.prac01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_library.*

class LibraryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        Glide.with(this)
            .load("https://cdn.vox-cdn.com/thumbor/" +
                    "Yt1avchDkHqEqJuhYZ3YjKF3kFc=/0x0:1700x960/" +
                    "1200x675/filters:focal(714x344:986x616)/" +
                    "cdn.vox-cdn.com/uploads/chorus_image/" +
                    "image/57514059/mario.0.jpg")
            .centerCrop()
            .into(img)

        Glide.with(this)
            .load("https://cdn.vox-cdn.com/thumbor/" +
                    "Yt1avchDkHqEqJuhYZ3YjKF3kFc=/0x0:1700x960/" +
                    "1200x675/filters:focal(714x344:986x616)/" +
                    "cdn.vox-cdn.com/uploads/chorus_image/" +
                    "image/57514059/mario.0.jpg")
            .into(img2)
    }
}
