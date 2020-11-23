package com.example.prac01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycler_view.*
import org.w3c.dom.Text

class RecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val carList = ArrayList<CarForList>()
        for (i in 0 until 50) {
            carList.add(
                CarForList(
                    "" + i + " 번째 자동차",
                    "" + i + " 순위 엔진"
                )
            )
        }

        val adapter = RecyclerViewAdapter(carList, LayoutInflater.from(this))
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this)
//        recycler_view.layoutManager = GridLayoutManager(this,2)

    }
}

class RecyclerViewAdapter(
    val itemList:ArrayList<CarForList>,
    val inflater:LayoutInflater
): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val carName:TextView
        val carEngine:TextView

        init {
            carName = itemView.findViewById(R.id.car_name)
            carEngine = itemView.findViewById(R.id.car_engine)

            itemView.setOnClickListener {
                val position:Int = adapterPosition
                val engineName = itemList.get(position).engine
                Log.d("engine",engineName)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.ViewHolder {
        // 뷰를 그려주는 부분
        val view = inflater.inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        // 전체 사이즈를 알려주는 부분
        // ListView 의 getCount 와 유사
        return itemList.size
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
        // ListView 에서 ViewHolder 를 만들어
        // tag 를 달아 재활용하는 역할
        holder.carName.setText(itemList.get(position).name)
        holder.carEngine.setText(itemList.get(position).engine)

    }
}