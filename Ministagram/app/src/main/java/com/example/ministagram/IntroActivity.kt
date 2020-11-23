package com.example.ministagram

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class IntroActivity:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intro_view)

        try{
            Thread.sleep(3000)
            val intent = Intent(this, EmailSignUpActivity::class.java)
            startActivity(intent)
            finish()
        }catch (e:Exception){
            return
        }
    }
}