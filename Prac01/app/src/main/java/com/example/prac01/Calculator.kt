package com.example.prac01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_calculator.*

class Calculator : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        var new: String = "0"
        var old: String = "0"
        var count: Int = 0
        var result_1:Int
        var result_2:Float

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
        plus.setOnClickListener {
            old = new
            count += 1
            new = "0"
            result.setText(new)
        }
        minus.setOnClickListener {
            old = new
            count += 2
            new = "0"
            result.setText(new)
        }
        multi.setOnClickListener {
            old = new
            count += 3
            new = "0"
            result.setText(new)
        }
        div.setOnClickListener {
            old = new
            count += 4
            new = "0"
            result.setText(new)
        }
        reset.setOnClickListener {
            new = "0"
            old = "0"
            count = 0
            result.setText(new)
        }
        calc.setOnClickListener {
            when (count) {
                1 -> {
                    result_1 = old.toInt() + new.toInt()
                    result.setText(result_1.toString())
                    count = 0
                }

                2 -> {
                    result_1 = old.toInt()-new.toInt()
                    result.setText(result_1.toString())
                    count = 0
                }

                3 -> {
                    result_1 = old.toInt()*new.toInt()
                    result.setText(result_1.toString())
                    count = 0
                }

                4 -> {
                    if(new>old){
                        result_2 = old.toFloat()%new.toFloat()
                        result.setText(result_2.toString())
                        count = 0
                    }else{
                        result_1 = old.toInt()/new.toInt()
                        result_2 = old.toFloat()%new.toFloat()
                        result.setText((result_1+result_2).toString())
                        count = 0
                    }
                    count=0
                }
            }
        }
    }
}
