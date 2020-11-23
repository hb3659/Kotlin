package com.example.ministagram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_my_post_list.*
import kotlinx.android.synthetic.main.activity_my_post_list.Upload
import kotlinx.android.synthetic.main.activity_my_post_list.userInfo
import kotlinx.android.synthetic.main.activity_my_post_list.allList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.POST

class MyPostListActivity : AppCompatActivity() {

    lateinit var myPostRecyclerView: RecyclerView
    lateinit var glide: RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_post_list)

        myPostRecyclerView = my_post_recycler_view
        glide = Glide.with(this)
        createList()

        userInfo.setOnClickListener {
            startActivity(Intent(this, UserInfoActivity::class.java))
        }
        allList.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        Upload.setOnClickListener {
            startActivity(Intent(this, UploadActivity::class.java))
        }
    }

    fun createList() {
        (application as MasterApp).service.getUserPostList().enqueue(
            object : Callback<Array<Post>> {
                override fun onFailure(call: Call<Array<Post>>, t: Throwable) {

                }

                override fun onResponse(call: Call<Array<Post>>, response: Response<Array<Post>>) {
                    if(response.isSuccessful){
                        val myPostList = response.body()
                        val adapter = myPostAdapter(
                            myPostList!!,
                            LayoutInflater.from(this@MyPostListActivity),
                            glide
                        )
                        myPostRecyclerView.adapter = adapter
                        myPostRecyclerView.layoutManager =
                            LinearLayoutManager(this@MyPostListActivity)
                    }
                }
            }
        )
    }
}

class myPostAdapter(
    var postList: Array<Post>,
    val inflater: LayoutInflater,
    val glide: RequestManager
) : RecyclerView.Adapter<myPostAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val postOwner: TextView
        val postImage: ImageView
        val postContent: TextView

        init {
            postContent = itemView.findViewById(R.id.post_content)
            postImage = itemView.findViewById(R.id.post_img)
            postOwner = itemView.findViewById(R.id.post_owner)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.ministagram_item_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.postOwner.setText(postList.get(position).owner)
        holder.postContent.setText(postList.get(position).content)
        glide.load(postList.get(position).image).into(holder.postImage)
    }
}
