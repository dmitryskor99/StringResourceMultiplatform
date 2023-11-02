package ru.wb.stringesourcemultiplatform

import android.app.Application
import ru.wb.stringresourcemultiplatform.ResourceStringConfig

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        ResourceStringConfig.setLocale(Russian())
    }
}