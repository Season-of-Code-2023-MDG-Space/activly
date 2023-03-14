package com.example.activly

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.google.firebase.auth.FirebaseAuth
import com.example.activly.databinding.ActivityMainBinding
import com.example.activly.NotificationService as Notif


class MainActivity : AppCompatActivity(), MyListener{
    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override var default_notification_channel_id: Any = ""
    private var NOTIFICATION_CHANNEL_ID = "10001"
    override fun setValue(notifmessage: String?) {
        Log.i("", "setval")
        if (notifmessage != null) {
            Log.i("MESSAGE>>>>>", notifmessage)
        }
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        Notif().setListener(this)
        val mNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Log.i("","hi****************")
            val importance = NotificationManager.IMPORTANCE_HIGH
            val notificationChannel = NotificationChannel(NOTIFICATION_CHANNEL_ID, "NOTIFICATION_CHANNEL_NAME", importance)
//            mBuilder.setChannelId(NOTIFICATION_CHANNEL_ID)
            mNotificationManager.createNotificationChannel(notificationChannel)
        }
//        mNotificationManager.notify(System.currentTimeMillis().toInt())

        var bt1 = findViewById<Button>(R.id.loginbtn)
        bt1.setOnClickListener {
            val username: String = findViewById<EditText>(R.id.login_username).text.toString()
            val password: String = findViewById<EditText>(R.id.login_password).text.toString()
            var username2: EditText? = findViewById(R.id.login_username)

            if (username.isNotEmpty() && password.isNotEmpty()) {
                if (isEmail(username2) == false) {
                    Toast.makeText(this, "You must enter valid email.", Toast.LENGTH_SHORT).show()
                } else {
                    firebaseAuth.signInWithEmailAndPassword(username, password)
                        .addOnCompleteListener {
                            if (it.isSuccessful) {
                                Toast.makeText(this, "Logging in...", Toast.LENGTH_SHORT).show()
                                val intent2 = Intent(this, PreferenceActivity::class.java)
                                startActivity(intent2)
                            } else {
                                Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }
                }
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()
            }
        }
//            if (username.isEmpty() || password.isEmpty()) {
//                Toast.makeText(this, "You must enter your details.", Toast.LENGTH_SHORT).show()
//            } else if (isEmail(username2)==false) {
//                Toast.makeText(this, "You must enter valid email.", Toast.LENGTH_SHORT).show()
//            }
//            else {
//                Toast.makeText(this, "Logging in...", Toast.LENGTH_SHORT).show()
//                val intent2 = Intent(this, PreferenceActivity::class.java)
//                startActivity(intent2)
//            }
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
