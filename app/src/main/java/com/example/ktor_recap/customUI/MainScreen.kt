package com.example.ktor_recap.customUI

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainScreen() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "AAAA",
            fontSize = 30.sp
        )
        Text(
            text = "BBBB",
            fontSize = 30.sp
        )
        Text(
            text = "CCCC",
            fontSize =30.sp
        )
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = {}) {
            Text(text = "Pull from Ktor",
                fontSize = 20.sp)
        }


    }
}