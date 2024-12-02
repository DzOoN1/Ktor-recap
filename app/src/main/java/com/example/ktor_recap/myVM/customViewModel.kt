package com.example.ktor_recap.myVM

import android.provider.ContactsContract
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.ktor_recap.customClasses.Note
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import kotlin.random.Random


class customViewModel : ViewModel() {
    var noteId by mutableStateOf("")
    var noteTitle by mutableStateOf("")
    var noteNumberOfPages by mutableStateOf("")
    var listAllNotes: MutableList<Note> by mutableStateOf(
        mutableListOf()
    )

    suspend fun getHelloWorld() {
        val client = HttpClient(CIO)
        val response: HttpResponse = client.get("http://10.0.2.2:8080")
        val bodyResponse = response.bodyAsText()
        noteTitle = bodyResponse
        client.close()
    }

    suspend fun getRandomNote() {
        val client = HttpClient(CIO) {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }
        var random = Random.nextInt(1, 10)
        val clientR = client.get("http://10.0.2.2:8080/$random").body<Note>()
        noteId = clientR.id
        noteTitle = clientR.title
        noteNumberOfPages = clientR.numberOfPages

        client.close()
    }

    suspend fun getAllNotes() {
        val client = HttpClient(CIO) {
            install(io.ktor.client.plugins.contentnegotiation.ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }


        }
        listAllNotes = client.get("http://10.0.2.2:8080/notes").body()

        client.close()


    }
}