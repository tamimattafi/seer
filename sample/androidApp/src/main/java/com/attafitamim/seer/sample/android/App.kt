package com.attafitamim.seer.sample.android

import android.app.Application
import com.attafitamim.seer.libs.console.ConsoleLogger
import com.attafitamim.seer.libs.core.facade.Seer

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Seer.init(ConsoleLogger())
    }
}
