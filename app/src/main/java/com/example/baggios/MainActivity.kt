package com.example.baggios

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.baggios.navigation.NavGraph
import com.example.baggios.ui.theme.BaggiosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BaggiosTheme {
                NavGraph()

                }
            }
        }
    }


