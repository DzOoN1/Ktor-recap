package com.example.ktor_recap.di

import com.example.ktor_recap.myRepository.MyRepository
import com.example.ktor_recap.myRepository.NotesRepository
import com.example.ktor_recap.myVM.customViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single<MyRepository>{
        NotesRepository()
    }
    viewModel { customViewModel(get()) }
}