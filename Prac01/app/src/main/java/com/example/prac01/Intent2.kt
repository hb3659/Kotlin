package com.example.prac01

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.prac01.Kotiln.number1
import kotlinx.android.synthetic.main.activity_intnet2.*

class Intent2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intnet2)

        result.setOnClickListener {
            val num1 = intent.getIntExtra("number1",0)
            val num2 = intent.getIntExtra("number2",0)

            Log.d("number", ""+num1)
            Log.d("number", ""+num2)

            val result = num1 + num2
            val resultIntent = Intent()
            resultIntent.putExtra("result", result)
            setResult(Activity.RESULT_OK, resultIntent)

            finish()    // -> Activity 종료
        }
    }
}
