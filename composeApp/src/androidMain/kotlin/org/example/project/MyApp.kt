package org.example.project

import android.app.Application
import data.di.initKoin

class MainApp: Application() {
  override fun onCreate() {
    super.onCreate()
    initKoin {
      applicationContext
    }
  }
}