package com.example.prac01

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_phone_book_with_recycler_view.*

class PhoneBookWithRecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book_with_recycler_view)

        with(phonebook_recycler_view) {
            this.adapter = PhoneBookRecyclerAdapter(
                phonebookList = createFakePhoneBook(50),
                Inflater = LayoutInflater.from(this@PhoneBookWithRecyclerViewActivity),
                activity = this@PhoneBookWithRecyclerViewActivity
            )
            this.layoutManager =
                LinearLayoutManager(this@PhoneBookWithRecyclerViewActivity)
        }

    }

    fun createFakePhoneBook(
        fakeNumber: Int = 10,
        phoneBook: PhoneBook = PhoneBook()
    ): PhoneBook {
        for (i in 0 until fakeNumber) {
            phoneBook.addPerson(
                Person(
                    name = "" + i + "번째 사람",
                    number = "" + i + "번째 사람의 전화번호"
                )
            )
        }
        return phoneBook
    }
}

class PhoneBookRecyclerAdapter(
    val phonebookList: PhoneBook,
    val Inflater: LayoutInflater,
    val activity: Activity
) : RecyclerView.Adapter<PhoneBookRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val personName: TextView

        init {
            personName = ItemView.findViewById(R.id.person_name)
            ItemView.setOnClickListener {
                val intent = Intent(activity, Test_03_Intent::class.java)

                intent.putExtra("name", phonebookList.personList.get(adapterPosition).name)
                intent.putExtra("number", phonebookList.personList.get(adapterPosition).number)

                activity.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = Inflater.inflate(R.layout.phone_number, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return phonebookList.personList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.personName.setText(phonebookList.personList.get(position).name)
    }
}
