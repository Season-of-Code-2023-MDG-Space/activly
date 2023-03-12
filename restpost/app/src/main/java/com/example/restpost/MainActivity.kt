package com.example.restpost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.restpost.R
import com.example.restpost.UserPost
import com.example.restpost.apiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tt=findViewById<TextView>(R.id.t1)

        val retrofitbuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()

        val jsonplaceholder = retrofitbuilder.create(apiInterface::class.java)
        val userpost = UserPost(1,66,"title","This is the body")
        val call = jsonplaceholder.sendUserData(userpost)

        call.enqueue(object: Callback<UserPost>{
            override fun onResponse(call: Call<UserPost>, response: Response<UserPost>) {
                tt.text=response.code().toString()
            }

            override fun onFailure(call: Call<UserPost>, t: Throwable) {
                tt.text=t.message.toString()
            }

        })
    }
}