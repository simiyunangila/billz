package com.example.billz

import android.app.Application
import android.content.Context

class BillApp:Application() {
    companion object{
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext

    }
}