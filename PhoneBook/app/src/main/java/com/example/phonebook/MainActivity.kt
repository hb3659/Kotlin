package com.example.phonebook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.phone_book.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createPhoneBook(createFakePhoneBook(30))


    }

    fun createFakePhoneBook(
        fakeNumber: Int = 10,
        phoneBook: PhoneBook = PhoneBook()
    ): PhoneBook {
        for (i in 0 until fakeNumber) {
            phoneBook.addPerson(
                Person(
                    name = "Person " + i,
                    number = "Person " + i + " 의 전화번호"
                )
            )
        }
        return phoneBook
    }

    fun createPhoneBook(phoneBook: PhoneBook) {
        val inflater = LayoutInflater.from(this)
        val container = findViewById<LinearLayout>(R.id.list_container)

        for (i in 0 until phoneBook.personList.size){
            val view = layoutInflater.inflate(R.layout.phone_book,null)
            val PersonNameView = view.findViewById<TextView>(R.id.person_name)
            PersonNameView.setText(phoneBook.personList.get(i).name)
            addsetOnClickListener(phoneBook.personList.get(i), view)
            container.addView(view)
        }
    }

    fun addsetOnClickListener(person: Person, view:View){
        view.setOnClickListener{
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("name", person.name)
            intent.putExtra("number", person.number)
            startActivity(intent)
        }
    }
}

class Person(var name: String, var number: String) {

}

class PhoneBook() {
    // 전화번호부
    val personList = ArrayList<Person>()

    fun addPerson(person: Person) {
        personList.add(person)
    }
}
