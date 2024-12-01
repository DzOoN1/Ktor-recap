package com.example.ktor_recap.myVM

import android.provider.ContactsContract.CommonDataKinds.Note
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.client.*
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import kotlinx.serialization.json.Json
// chat gpt
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import io.ktor.client.plugins.serialization
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.serialization.*
import io.ktor.client.request.*
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import io.ktor.serialization.kotlinx.json.*

class customViewModel: ViewModel() {
    var noteId by mutableStateOf(1)
    var noteTitle by mutableStateOf("")
    var noteNumberOfPages by mutableIntStateOf(1)
    var listAllNotes:MutableList<Note> by mutableStateOf(mutableListOf())

    suspend fun getHelloWorld(){
        val client = HttpClient(CIO)
        val response: HttpResponse = client.get("http://10.0.2.2:8080")
        val bodyResponse = response.bodyAsText()
        noteTitle = bodyResponse
        client.close()
    }
    suspend fun getAllNotes(){
        val client = HttpClient(CIO){
        install(Serialization)
        }
            val response: Note = client.get("http://10.0.2.2:8080/notes").body()
       // listAllNotes.addAll(listOf(response))
        Log.d("TAG", "getAllNotes:$response ")
        client.close()


    }
}