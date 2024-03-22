package com.example.customtabsactiondemo

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class MyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val url = intent.dataString
        val sendIntent = Intent()
        sendIntent.setAction(Intent.ACTION_SEND)
        sendIntent.putExtra(Intent.EXTRA_TEXT, url)
        sendIntent.setType("text/plain")
        val shareIntent = Intent.createChooser(sendIntent, null).apply { setFlags(Intent.FLAG_ACTIVITY_NEW_TASK) }
        context.startActivity(shareIntent)
    }
}
