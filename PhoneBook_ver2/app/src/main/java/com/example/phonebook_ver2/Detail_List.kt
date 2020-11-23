package com.example.phonebook_ver2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail__list.*

class Detail_List : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail__list)

        val Name = intent.getStringExtra("name")
        val Number = intent.getStringExtra("number")

        detail_name.setText(Name)
        detail_number.setText(Number)
    }
}
