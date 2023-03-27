package com.example.usageaccessbug

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.usageaccessbug.ui.theme.Purple700
import com.example.usageaccessbug.ui.theme.UsageAccessBugTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UsageAccessBugTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Purple700
                ) {
                    Button(
                        modifier = Modifier.wrapContentSize(),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                        onClick = { openUsageAccessSettingsIntent() })
                    {
                        Text(text = "Enable Usage Access")
                    }
                }
            }
        }
    }

    private fun openUsageAccessSettingsIntent() {
        try {
            //opens app-specific screen
            startActivity(Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS).apply {
                data = Uri.fromParts("package", packageName, null)
            })
        } catch (e: Throwable) {
            //opens usage access settings screen
            startActivity(Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS))
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    UsageAccessBugTheme {
        Greeting("Android")
    }
}