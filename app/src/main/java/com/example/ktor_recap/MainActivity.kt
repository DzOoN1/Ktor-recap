package com.example.ktor_recap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.ktor_recap.customUI.HelloScreen
import com.example.ktor_recap.customUI.MainScreen
import com.example.ktor_recap.myVM.customViewModel
import com.example.ktor_recap.navigation.myNavigation
import com.example.ktor_recap.ui.theme.KtorrecapTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[customViewModel::class.java]
        enableEdgeToEdge()
        setContent {
            KtorrecapTheme {
                myNavigation(viewModel)
            }
        }
    }
}
