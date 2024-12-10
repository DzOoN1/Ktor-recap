package com.example.ktor_recap

import com.example.ktor_recap.di.appModule
import org.junit.Test
import org.koin.test.*
import org.koin.test.verify.verify


class CheckModulesTest : KoinTest {

    @Test
    fun checkAllModules() {
        appModule.verify()
    }
}