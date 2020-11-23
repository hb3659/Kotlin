package com.example.prac01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_test_01.*

class Test_01 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_01)

        // new -> old (new+old)
        var new = "0"
        var old = "0"

        num1.setOnClickListener {
            new = new + "1"
            result.setText(new)
        }
        num2.setOnClickListener {
            new = new + "2"
            result.setText(new)
        }
        num3.setOnClickListener {
            new = new + "3"
            result.setText(new)
        }
        num4.setOnClickListener {
            new = new + "4"
            result.setText(new)
        }
        num5.setOnClickListener {
            new = new + "5"
            result.setText(new)
        }
        num6.setOnClickListener {
            new = new + "6"
            result.setText(new)
        }
        num7.setOnClickListener {
            new = new + "7"
            result.setText(new)
        }
        num8.setOnClickListener {
            new = new + "8"
            result.setText(new)
        }
        num9.setOnClickListener {
            new = new + "9"
            result.setText(new)
        }
        num0.setOnClickListener {
            new = new + "0"
            result.setText(new)
        }
        reset.setOnClickListener {
            new = "0"
            old = "0"
            result.setText("0")
        }
        plus.setOnClickListener {
            old = (old.toInt() + new.toInt()).toString()
            new = "0"
            result.setText(old)
        }


    }
}
