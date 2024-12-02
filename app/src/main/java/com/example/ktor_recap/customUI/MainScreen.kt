package com.example.ktor_recap.customUI

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.ktor_recap.customClasses.Note
import com.example.ktor_recap.myVM.customViewModel
import kotlinx.coroutines.launch

@Composable
fun MainScreen(viewModel: customViewModel, navController: NavController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = viewModel.noteId.toString(),
            fontSize = 30.sp
        )
        Text(
            text = viewModel.noteTitle,
            fontSize = 30.sp
        )
        Text(
            text = viewModel.noteNumberOfPages.toString(),
            fontSize =30.sp
        )
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = {
            viewModel.viewModelScope.launch {
             //  val text = viewModel.getHelloWorld()
              //  viewModel.getAllNotes()
                viewModel.getRandomNote()

            }
        }) {
            Text(text = "Random Pull from Ktor",
                fontSize = 20.sp)
        }


    }
    Column(
        modifier = Modifier.fillMaxSize().padding(40.dp),

        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    ) {
        Button(onClick = {
            viewModel.viewModelScope.launch {
                viewModel.getAllNotes()
            }
            navController.navigate("AllNotes")
        }) {
            Text(text = "All Notes")
        }
    }
}


