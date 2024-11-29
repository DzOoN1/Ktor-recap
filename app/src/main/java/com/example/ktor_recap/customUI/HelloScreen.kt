package com.example.ktor_recap.customUI

import androidx.compose.foundation.Image
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ktor_recap.R

@Composable
fun HelloScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Welcome to Ktor client app",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
            )
        Image(
            painter = painterResource(R.drawable.ktor),
            contentDescription = "Ktor logo"
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {}) {
            Text(text = "Next Page",
                fontSize = 18.sp)
        }
    }

}