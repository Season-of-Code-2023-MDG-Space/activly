package com.example.activly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.MyListener
import com.NotificationService
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent

class Clubsnotificationpage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clubsnotificationpage)
        }
    }
}
class Notifunc {
    val mNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    override fun setValue(packageName: String?) {
        packageName=myListener
    }
}
}