package com.example.prac01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_thread.*

class ThreadActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)


        val runnable:Runnable = object:Runnable{
            override fun run() {
                Log.d("thread-1", "Thread is made")
            }
        }

        val thread:Thread = Thread(runnable)
        Btn.setOnClickListener {
            thread.start()
        }

        Thread(object:Runnable{
            override fun run() {
                Log.d("thread-2", "Thread is made")
            }
        }).start()

        Thread(Runnable {
            Thread.sleep(2000)
            Log.d("thread-3", "Thread is made")
            runOnUiThread {
                Btn.setBackgroundColor(getColor(R.color.textView_color))
            }

            // 메인 쓰레드가 아닌 쓰레드에서는 UI를 변경할 수 없다
            // 메인 쓰레드 == UI 쓰레드
            // 개발자가 쓰레드를 관리할 일은 거의 없다
        }).start()
    }
}
