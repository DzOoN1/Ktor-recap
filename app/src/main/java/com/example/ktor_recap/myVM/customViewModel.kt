package com.example.ktor_recap.myVM

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText

class customViewModel: ViewModel() {

    var noteId by mutableStateOf(1)
    var noteTitle by mutableStateOf("")
    var noteNumberOfPages by mutableStateOf(1)

    suspend fun getHelloWorld(){
        val client = HttpClient(CIO)
        val response: HttpResponse = client.get("http://10.0.2.2:8080")
        val bodyResponse = response.bodyAsText()
        noteTitle = bodyResponse
        client.close()
    }
}