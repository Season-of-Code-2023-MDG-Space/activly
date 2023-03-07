package com.example.activly

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class PreferenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferences)
        var btn1=findViewById<Button>(R.id.button2)
        btn1.setOnClickListener(View.OnClickListener{
            val intent1 = Intent(this,OrgActivity::class.java)
            startActivity(intent1)
        }
        )
    }
}