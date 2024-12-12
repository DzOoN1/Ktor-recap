package com.example.ktor_recap.customUI

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.testing.TestNavHostController
import com.example.ktor_recap.myRepository.MyRepository
import com.example.ktor_recap.myRepository.NotesRepository
import com.example.ktor_recap.myVM.customViewModel
import io.ktor.websocket.Frame
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import androidx.compose.ui.test.hasText
import com.example.ktor_recap.customClasses.Note
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.test.runTest
import org.junit.Assert

class MainScreenKtTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    lateinit var navController: TestNavHostController

    @Before
    fun setUpNavHost() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            NavHost(navController, startDestination = "MainScreen") {
                composable("HelloScreen") { HelloScreen(navController) }
                composable("MainScreen") { MainScreen(viewModel = customViewModel(NotesRepository()), navController) }
                composable("AllNotes") { AllNotes(viewModel= customViewModel(NotesRepository()))}
            }

        }
    }

    @Test
    fun screen_look_mainscreen() {
        composeTestRule.onNodeWithText("Random Pull from Ktor").assertIsDisplayed()
        composeTestRule.onNodeWithText("All Notes").assertIsDisplayed()
    }

    @Test
    fun click_random_pull_from_ktor() {
        composeTestRule.onNodeWithText("Random Pull from Ktor").performClick()
        val client = HttpClient(CIO)
        fun testRealRequest() = runTest {
            val response = client.get("\"http://10.0.2.2:8080/$1\"")
            val body = response.bodyAsText()
            assertEquals(200, response.status.value)
            assert(body.isNotEmpty())
            composeTestRule.onNodeWithTag("noteId").assertIsDisplayed()
            composeTestRule.onNodeWithTag("noteTitle").assertIsDisplayed()
            composeTestRule.onNodeWithTag("noteNumberOfPages").assertIsDisplayed()

        }

    }
    @Test
    fun navigate_to_allNotesScrenn(){
        composeTestRule.onNodeWithText("All Notes").performClick()
        val route = navController.currentBackStackEntry?.destination?.route
        Assert.assertEquals(route,"AllNotes")
    }
}