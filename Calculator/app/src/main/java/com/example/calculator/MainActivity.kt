package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var new:String = ""
        var old:String = ""
        var count = 0
        var calc:Int
        var floatCalc:Float
        var switch:Boolean = true

        Num0.setOnClickListener {
            new = new +"0"
            NumResult.setText(new)
        }
        Num1.setOnClickListener {
            new = new +"1"
            NumResult.setText(new)
        }
        Num2.setOnClickListener {
            new = new +"2"
            NumResult.setText(new)
        }
        Num3.setOnClickListener {
            new = new +"3"
            NumResult.setText(new)
        }
        Num4.setOnClickListener {
            new = new +"4"
            NumResult.setText(new)
        }
        Num5.setOnClickListener {
            new = new +"5"
            NumResult.setText(new)
        }
        Num6.setOnClickListener {
            new = new +"6"
            NumResult.setText(new)
        }
        Num7.setOnClickListener {
            new = new +"7"
            NumResult.setText(new)
        }
        Num8.setOnClickListener {
            new = new +"8"
            NumResult.setText(new)
        }
        Num9.setOnClickListener {
            new = new +"9"
            NumResult.setText(new)
        }

        plus.setOnClickListener {
            old = new
            new = ""
            count += 1
        }
        minus.setOnClickListener {
            old = new
            new = ""
            count += 2
        }
        multi.setOnClickListener {
            old = new
            new = ""
            count += 3
        }
        div.setOnClickListener {
            old = new
            new = ""
            count += 4
        }

        result.setOnClickListener {
            when(count){
                1 -> {
                    if(switch==true) {
                        calc = new.toInt() + old.toInt()
                        NumResult.setText(calc.toString())
                        new = calc.toString()
                        count = 0
                    }else{
                        floatCalc = old.toFloat()+new.toFloat()
                        NumResult.setText(floatCalc.toString())
                        new = floatCalc.toString()
                        count=0
                    }
                }
                2 -> {
                    if(switch==true) {
                        calc = old.toInt() - new.toInt()
                        NumResult.setText(calc.toString())
                        new = calc.toString()
                        count = 0
                    }else{
                        floatCalc = old.toFloat()-new.toFloat()
                        NumResult.setText(floatCalc.toString())
                        new = floatCalc.toString()
                        count=0
                    }
                }
                3 -> {
                    if(switch==true) {
                        calc = new.toInt() * old.toInt()
                        NumResult.setText(calc.toString())
                        new = calc.toString()
                        count = 0
                    }else{
                        floatCalc = old.toFloat()*new.toFloat()
                        NumResult.setText(floatCalc.toString())
                        new = floatCalc.toString()
                        count=0
                    }
                }
                4 -> {
                    if(new.toInt()!=0) {
                        floatCalc = old.toFloat() / new.toFloat()
                        NumResult.setText(floatCalc.toString())
                        new = floatCalc.toString()
                        count = 0
                        switch = false
                    }else{
                        Toast.makeText(this,
                            "0으로 나눌 수 없습니다",Toast.LENGTH_LONG).show()
                    }
                }
            }
        }

        clear.setOnClickListener {
            new = ""
            old = ""
            count = 0
            NumResult.setText("0")
            switch = true
        }
    }
}
