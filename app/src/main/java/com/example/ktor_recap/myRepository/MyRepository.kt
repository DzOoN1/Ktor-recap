package com.example.ktor_recap.myRepository

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.ktor_recap.customClasses.Note
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import kotlin.random.Random

interface MyRepository {

    suspend fun getHelloWorld(): String
    suspend fun getRandomNote(): Note
     suspend fun getAllNotes(): MutableList<Note>
}

class NotesRepository: MyRepository{

    var noteId = ""
    var noteTitle = ""
    var noteNumberOfPages = ""
    var listAllNotes: MutableList<Note> = mutableListOf()

    override suspend fun getHelloWorld(): String {
        val client = HttpClient(CIO)
        val response: HttpResponse = client.get("http://10.0.2.2:8080")
        val bodyResponse = response.bodyAsText()
        noteTitle = bodyResponse
        client.close()
        return noteTitle
    }

    override suspend fun getRandomNote(): Note {

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
        return Note(
            noteId, noteTitle, noteNumberOfPages
        )

    }

    override suspend fun getAllNotes(): MutableList<Note> {
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
        return listAllNotes
    }

}