package com.example.ktor_recap.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringArrayResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ktor_recap.customUI.HelloScreen
import com.example.ktor_recap.customUI.MainScreen

@Composable
fun myNavigation() {
    val navControler = rememberNavController()
    NavHost(navControler, startDestination = "HelloScreen", builder = {
        composable("HelloScreen") { HelloScreen(navControler) }
        composable("MainScreen") { MainScreen() }
    })

}