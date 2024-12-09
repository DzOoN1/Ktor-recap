package com.example.ktor_recap.di

import android.app.Application
import com.example.ktor_recap.myRepository.MyRepository
import com.example.ktor_recap.myRepository.NotesRepository
import com.example.ktor_recap.myVM.customViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.context.startKoin
import org.koin.dsl.bind
import org.koin.dsl.module

class MyApplication: Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(appModule)
        }
    }
}

