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
import androidx.navigation.NavHost
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
import io.mockk.*

class HelloScreenKtTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    lateinit var navController: TestNavHostController

    @Before
    fun setUpNavHost() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            NavHost(navController, startDestination = "HelloScreen") {
                composable("HelloScreen") { HelloScreen(navController) }
                composable("MainScreen") { /* MainScreen content here */ }
            }
        }
    }
    @Test
    fun screen_look_helloscreen() {
        composeTestRule.onNodeWithText("Next Page").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("Ktor logo").assertIsDisplayed()
        composeTestRule.onNodeWithText("Welcome to Ktor client app").assertIsDisplayed()
    }
    @Test
    fun button_click_navigate_to_mainScreen() {

        composeTestRule.onNodeWithText("Next Page").performClick()
        val route = navController.currentBackStackEntry?.destination?.route
        Assert.assertEquals(route, "MainScreen")
    }
}

