package com.example.ktor_recap.customUI

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.testing.TestNavHostController
import com.example.ktor_recap.MainActivity
import com.example.ktor_recap.myVM.customViewModel
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock


class HelloScreenKtTest {
    @get:Rule
    val composeTestRule = createComposeRule()



    @Test
    fun screen_look() {
        composeTestRule.setContent {
            HelloScreen(navController = rememberNavController())
        }
        composeTestRule.onNodeWithText("Next Page").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Ktor logo").assertIsDisplayed()
        composeTestRule.onNodeWithText("Welcome to Ktor client app").assertIsDisplayed()
    }

    @Test
    fun button_click(){
        composeTestRule.setContent {
            val navControler = rememberNavController()
            NavHost(navControler, startDestination = "HelloScreen", builder = {
                composable("HelloScreen") { HelloScreen(navControler) }
                composable("MainScreen") { MainScreen(viewModel = viewModel(),navControler) }
                composeTestRule.onNodeWithText("Next Page").performClick()
                composeTestRule.runOnIdle {
                   assert(navControler.currentBackStackEntry?.destination?.route == "MainScreen")
                }
            })
        }



    }
}

