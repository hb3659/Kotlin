package com.example.prac01

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_shared_perference.*

class SharedPerferenceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_perference)

        // SharedPreference 에 저장하는 방법
//        val sharedPreference = getSharedPreferences("sp1", Context.MODE_PRIVATE)

        // MOD
        // - mode_private : 생성한 application 에서만 사용 가능
        // - mode_world_readable : 다른 application 에서 사용 가능 -> 읽기만 가능
        // - mode_world_writable : 다른 application 에서 사용 가능 -> 기록도 가능
        // - mode_multi_process : 이미 호출되어 사용중인지 체크
        // - mode_append : 기존 preference 에 신규로 추가

//        val editor = sharedPreference.edit()
//        editor.putString("hello", "안녕하세요")
//            .putString("goodBye", "안녕히 가세요")
//            .commit()

        save_Btn.setOnClickListener {
            val sharedPreference = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val editor = sharedPreference.edit()
            editor.putString("hello", "안녕하세요")
                .putString("goodBye", "안녕히 가세요")
                .commit()
        }

        load_Btn.setOnClickListener {
            // SharedPreference 에서 값을 불러오는 방법
            val sharedPreference = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val value1 = sharedPreference.getString("hello", "데이터 없음1")
            val value2 = sharedPreference.getString("goodBye", "데이터 없음2")
            Log.d("key-value", "Value : " + value1)
            Log.d("key-value", "Value : " + value2)
        }

        delete_Btn.setOnClickListener {
            val sharedPerference = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val Editor = sharedPerference.edit()
            Editor.remove("hello")
                .commit()
        }

        all_delete_Btn.setOnClickListener {
            val sharedPerference = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val Editor = sharedPerference.edit()
            Editor.clear()
                .commit()
        }
    }
}
