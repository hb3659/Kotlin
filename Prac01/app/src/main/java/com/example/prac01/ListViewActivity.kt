package com.example.prac01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list_view.*
import kotlinx.android.synthetic.main.item_view.view.*
import org.w3c.dom.Text

class ListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val carList = ArrayList<CarForList>()
        for (i in 0 until 50) {
            carList.add(
                CarForList(
                    "" + i + " 번째 자동차",
                    "" + i + " 순위 엔진"
                )
            )
        }

        val adapter = ListViewAdapter(carList, LayoutInflater.from(this))
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            val carName = (adapter.getItem(position) as CarForList).name
            val carEngine = (adapter.getItem(position) as CarForList).engine

            Toast.makeText(this, carName + " " + carEngine, Toast.LENGTH_SHORT).show()
        }
    }
}

class ListViewAdapter(
    var carForList: ArrayList<CarForList>,
    val layoutInflater: LayoutInflater
) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view:View
        val holder:viewHolder

        if(convertView == null){
            Log.d("convert","1")
            view = layoutInflater.inflate(R.layout.item_view, null)
            holder = viewHolder()

            holder.carName = view.findViewById(R.id.car_name)
            holder.carEngine = view.findViewById(R.id.car_engine)

            view.tag = holder
        }else{
            Log.d("convert","2")
            holder = convertView.tag as viewHolder
            view = convertView
        }
        holder.carName?.setText(carForList.get(position).name)
        holder.carEngine?.setText(carForList.get(position).engine)

        return view
    }

    override fun getItem(position: Int): Any {
        return carForList.get(position)
        // 그리고자 하는 아이템 리스트 중 하나(포지션에 해당하는)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
        // 리스트에 아이디를 부여하는 부분
    }

    override fun getCount(): Int {
        return carForList.size
        // 전체 사이즈를 알려주는 부분
    }
}

class viewHolder {
    var carName: TextView? = null
    var carEngine: TextView? = null
}
