package com.example.phonebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.phone_book.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        getPerson()

        back.setOnClickListener{
            onBackPressed()
        }
    }

    fun getPerson(){
        val name = intent.getStringExtra("name")
        val number = intent.getStringExtra("number")

        detail_name.setText(name)
        detail_number.setText(number)
    }
}
