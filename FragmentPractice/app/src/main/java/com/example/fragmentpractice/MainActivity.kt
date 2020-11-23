package com.example.fragmentpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Btn1.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frame_view, FragmentOne())
                .commit()
        }

        Btn2.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frame_view, FragmentTwo())
                .commit()
        }

        Btn3.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frame_view, FragmentThree())
                .commit()
        }
    }
}
