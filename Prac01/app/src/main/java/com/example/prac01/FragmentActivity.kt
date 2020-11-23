package com.example.prac01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_fragment.*

//class FragmentActivity : AppCompatActivity(), FragmentOne.OnDataPassListener {
//    override fun onDataPass(data: String?) {
//        Log.d("pass",""+data)
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_fragment)
//        Log.d("life_cycle", "onCreate")
//
//        val fragmentOne: FragmentOne = FragmentOne()
//        // 프라그먼트에 data를 넣어주는 방법
//        val bundle:Bundle = Bundle()
//        bundle.putString("hello","hello")
//        fragmentOne.arguments = bundle
//
//        Btn.setOnClickListener {
//            // 프라그먼트를 동적으로 작동하는 방법
//            // 프라그먼트 붙이는 방법 replace/add
//            val fragmentManager: FragmentManager = supportFragmentManager
//
//            // Transaction
//            // 작업의 단위 -> 시작과 끝이 있다
//            // 시작
//            val fragmentTransaction = fragmentManager.beginTransaction()
//            // 할일
//            fragmentTransaction.replace(R.id.container, fragmentOne)
//            // 끝
//            fragmentTransaction.commit()
//            // 끝을 내는 방법
//            // commit -> 시간 될 때 해 (조금 더 안정적)
//            // commitNow -> 지금 당장 해
//        }
//
//        Btn2.setOnClickListener {
////            // 프라그먼트 remove/detach 하는 방법
////            val FragmentManager = supportFragmentManager
////            val FragmentTrasaction = FragmentManager.beginTransaction()
////            FragmentTrasaction.remove(fragmentOne)
////            FragmentTrasaction.commit()
////        }
////    }
//
//    override fun onStart() {
//        super.onStart()
//        Log.d("life_cycle", "onStart")
//    }
//
//    override fun onResume() {
//        super.onResume()
//        Log.d("life_cycle", "onResume")
//    }
//
//    override fun onPause() {
//        super.onPause()
//        Log.d("life_cycle", "onPause")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        Log.d("life_cycle", "onStop")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        Log.d("life_cycle", "onDestroy")
//    }
//}
