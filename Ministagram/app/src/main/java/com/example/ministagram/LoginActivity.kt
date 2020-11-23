package com.example.ministagram

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        registerBtn.setOnClickListener {
            val intent = Intent(this, EmailSignUpActivity::class.java)
            startActivity(intent)
        }

        loginBtn.setOnClickListener {
            val username = user_email_input_box.text.toString()
            val password = user_pass_input_box.text.toString()
            (application as MasterApp).service.login(
                username, password
            ).enqueue(object : Callback<User> {
                override fun onFailure(call: Call<User>, t: Throwable) {

                }

                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if (response.isSuccessful) {
                        val user = response.body()
                        val token = user!!.token!!
                        saveUserToken(token, this@LoginActivity)
                        (application as MasterApp).createRetrofit()
                        Toast.makeText(
                            this@LoginActivity, "로그인 되었습니다", Toast.LENGTH_LONG
                        ).show()
                        startActivity(
                            Intent(this@LoginActivity, MainActivity::class.java)
                        )
                    }
                }
            })
        }
    }

    fun saveUserToken(token: String, activity: Activity) {
        val sp = getSharedPreferences("Login", Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString("Login", token)
            .commit()
    }
}
