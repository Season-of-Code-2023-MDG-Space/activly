package com.example.activly

import android.app.Notification
import android.content.Context
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log

interface MyListener {
    val default_notification_channel_id: Any
    fun setValue(packageName: String?)
}

class NotificationService : NotificationListenerService() {
    private val TAG = this.javaClass.simpleName
    var context: Context? = null
    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

    override fun onNotificationPosted(sbn: StatusBarNotification) {
        Log.i(TAG, "Notification posted.")
        Log.i(TAG, sbn.Notification)
        myListener!!.Notifunc.setValue(sbn.notification.extras.getString(Notification.EXTRA_TEXT))
    }

    fun setListener(myListener: MyListener?) {
        Companion.myListener = myListener
    }

    companion object {
        var myListener: MyListener? = null
    }
}