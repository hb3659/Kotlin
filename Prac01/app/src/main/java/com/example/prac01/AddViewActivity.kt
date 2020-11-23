package com.example.prac01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_add_view.*

class AddViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_view)


        // 아이템 리스트 준비
        val carList = ArrayList<CarForList>()
        for (i in 0 until 10) {
           carList.add(CarForList(""+i+" 번째 자동차",
            ""+i+" 순위 엔진"))
        }

        val container = findViewById<LinearLayout>(R.id.addViewCon)
        val inflater = LayoutInflater.from(this)
        for (i in 0 until carList.size){
            val itemView = inflater.inflate(R.layout.item_view, null)
            val carNameView = itemView.findViewById<TextView>(R.id.car_name)
            val carEngienView = itemView.findViewById<TextView>(R.id.car_engine)

            carNameView.setText(carList.get(i).name)
            carEngienView.setText(carList.get(i).engine)
            container.addView(itemView)
        }


    }

}

class CarForList(var name:String, var engine:String){

}
