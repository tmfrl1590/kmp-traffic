package com.kmp.traffic

import App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.kmp.traffic.database.getDatabaseBuilder

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MyApp.activity = this
        val database = getDatabaseBuilder(applicationContext)
        setContent {
            App(database)
        }
    }
}