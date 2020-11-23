package com.example.ministagram

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.Upload
import kotlinx.android.synthetic.main.activity_main.allList
import kotlinx.android.synthetic.main.activity_main.myList
import kotlinx.android.synthetic.main.activity_user_info.*

class UserInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)
        allList.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        myList.setOnClickListener {
            startActivity(Intent(this, MyPostListActivity::class.java))
        }
        Upload.setOnClickListener {
            startActivity(Intent(this, UploadActivity::class.java))
        }

        logout.setOnClickListener {
            val sharedPreference = getSharedPreferences("Login", Context.MODE_PRIVATE)
            val editor = sharedPreference.edit()
            editor.putString("Login", "null")
                .commit()
            (application as MasterApp).createRetrofit()
            finish()
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}
