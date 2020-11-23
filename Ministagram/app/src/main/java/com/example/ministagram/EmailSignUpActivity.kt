package com.example.ministagram

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import org.mozilla.javascript.tools.jsc.Main
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EmailSignUpActivity : AppCompatActivity() {

    lateinit var userMailView: EditText
    lateinit var userPassView_1: EditText
    lateinit var userPassView_2: EditText
    lateinit var registerBtn: ImageView
    lateinit var loginBtn: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if((application as MasterApp).CheckLogin()==true){
            finish()
            startActivity(Intent(this, MainActivity::class.java))
        }else {
            setContentView(R.layout.activity_email_sign_up)

            initView(this)
            setUpListener(this)
        }
    }

    fun setUpListener(activity: Activity) {
        registerBtn.setOnClickListener {
            register(this)
        }
        loginBtn.setOnClickListener {
            startActivity(
                Intent(
                    this@EmailSignUpActivity, LoginActivity::class.java
                )
            )
        }
    }

    fun register(activity: Activity) {
        val username = getUserMail()
        val password1 = getUserPass_1()
        val password2 = getUserPass_2()

        (application as MasterApp).service.register(
            username, password1, password2
        ).enqueue(object : Callback<User> {
            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(
                    activity, "가입에 실패하였습니다", Toast.LENGTH_SHORT
                ).show()
            }

            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    Toast.makeText(
                        activity, "가입에 성공하였습니다", Toast.LENGTH_SHORT
                    ).show()
                    val user = response.body()
                    val token = user!!.token!!
                    saveUserToken(token, activity)
                    (application as MasterApp).createRetrofit()
                    activity.startActivity(
                        Intent(activity, MainActivity::class.java)
                    )
                }
            }
        })
    }

    fun saveUserToken(token: String, activity: Activity) {
        val share = activity
            .getSharedPreferences("Login", Context.MODE_PRIVATE)
        val editor = share.edit()
        editor.putString("Login", token)
            .commit()
    }

    fun initView(activity: Activity) {
        userMailView = activity.findViewById(R.id.user_email_input_box)
        userPassView_1 = activity.findViewById(R.id.user_pass_input_box)
        userPassView_2 = activity.findViewById(R.id.user_pass_input_box_2)
        registerBtn = activity.findViewById(R.id.registerBtn)
        loginBtn = activity.findViewById(R.id.loginBtn)
    }

    fun getUserMail(): String {
        return userMailView.text.toString()
    }

    fun getUserPass_1(): String {
        return userPassView_1.text.toString()
    }

    fun getUserPass_2(): String {
        return userPassView_2.text.toString()
    }

}
