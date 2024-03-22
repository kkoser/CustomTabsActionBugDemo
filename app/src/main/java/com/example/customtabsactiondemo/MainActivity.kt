package com.example.customtabsactiondemo

import android.R
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.customtabsactiondemo.ui.theme.CustomTabsActionDemoTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CustomTabsActionDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }

        val url = "https://developers.android.com"

        val shareDescription = "share custom"
        val shareIcon = BitmapFactory.decodeResource(
            resources,
            R.drawable.ic_menu_share
        )

        /** Uncomment this to see the behavior with an Activity instead of a BroadcastReceiver

        // Create a PendingIntent to your BroadCastReceiver implementation
        val actionIntent = Intent(
            this.applicationContext, MyReceiver::class.java
        )
        val pendingIntent =
            PendingIntent.getBroadcast(
                applicationContext,
                0,  /* request code */
                actionIntent,
                PendingIntent.FLAG_MUTABLE
            )
        */

        // Create a PendingIntent to your BroadCastReceiver implementation
        val actionIntent = Intent(
            this.applicationContext, MyReceiver::class.java
        )
        val pendingIntent =
            PendingIntent.getBroadcast(
                applicationContext,
                0,  /* request code */
                actionIntent,
                PendingIntent.FLAG_MUTABLE
            )

        val intent = CustomTabsIntent.Builder()
            .setShareState(CustomTabsIntent.SHARE_STATE_OFF)
            .setActionButton(shareIcon, shareDescription, pendingIntent, false)
            .build()
        intent.launchUrl(this@MainActivity, Uri.parse(url))
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CustomTabsActionDemoTheme {
        Greeting("Android")
    }
}
