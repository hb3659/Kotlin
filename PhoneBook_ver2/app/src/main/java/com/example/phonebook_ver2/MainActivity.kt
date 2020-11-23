package com.example.phonebook_ver2

import android.app.Activity
import android.app.Person
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item.view.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.adapter = RecyclerViewAdapter(
            itemList = createFakeNumber(50),
            inflater = LayoutInflater.from(this),
            activity = this
        )

        recycler_view.layoutManager = LinearLayoutManager(this)
    }

    fun createFakeNumber(
        fakeNum: Int = 10,
        phoneBook: PhoneBook = PhoneBook()
    ): PhoneBook {
        for (i in 0 until fakeNum) {
            phoneBook.addPerson(
                Person1(
                    name = "Person " + i,
                    number = "Person " + i + " 's Number"
                )
            )
        }
        return phoneBook
    }
}

class PhoneBook() {
    var personList = ArrayList<Person1>()

    fun addPerson(person: Person1) {
        personList.add(person)
    }
}

class Person1(var name: String, var number: String) {

}

class RecyclerViewAdapter(
    val itemList: PhoneBook,
    val inflater: LayoutInflater,
    val activity: Activity
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val Name: TextView

        init {
            Name = itemView.findViewById(R.id.person_name)

            itemView.setOnClickListener {
                val position: Int = adapterPosition
                val intent = Intent(activity, Detail_List::class.java)

                intent.putExtra("name", itemList.personList.get(position).name)
                intent.putExtra("number", itemList.personList.get(position).number)

                activity.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.personList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.Name.setText(itemList.personList.get(position).name)
    }
}