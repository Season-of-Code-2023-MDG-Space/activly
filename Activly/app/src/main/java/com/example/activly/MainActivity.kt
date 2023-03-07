package com.example.activly

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var bt1 = findViewById<Button>(R.id.loginbtn)
        bt1.setOnClickListener {
            val username: String=findViewById<EditText>(R.id.login_username).text.toString()
            val password: String=findViewById<EditText>(R.id.login_password).text.toString()
            var username2: EditText?=findViewById(R.id.login_username)
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "You must enter your details.", Toast.LENGTH_SHORT).show()
            } else if (isEmail(username2)==false) {
                Toast.makeText(this, "You must enter valid email.", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "Logging in...", Toast.LENGTH_SHORT).show()
                val intent2 = Intent(this, PreferenceActivity::class.java)
                startActivity(intent2)
            }
        }
        var bt2 =findViewById<Button>(R.id.signupredirect)
        bt2.setOnClickListener {
            val intent3=Intent(this,Loginpage::class.java )
            startActivity(intent3)
        }
    }
    fun isEmail(text: EditText?): Boolean {
        val email: CharSequence = text!!.text.toString()
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}