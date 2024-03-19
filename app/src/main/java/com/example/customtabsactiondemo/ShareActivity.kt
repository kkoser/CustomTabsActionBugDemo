package com.example.customtabsactiondemo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ShareActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val url = intent.dataString
        val sendIntent = Intent()
        sendIntent.setAction(Intent.ACTION_SEND)
        sendIntent.putExtra(Intent.EXTRA_TEXT, url)
        sendIntent.setType("text/plain")
        val shareIntent = Intent.createChooser(sendIntent, null)
        this.startActivity(shareIntent)
        finish()
    }
}
