package com.attafitamim.seer.libs.console

import android.util.Log
import com.attafitamim.seer.libs.core.model.LogLevel

actual fun log(
    level: LogLevel,
    tag: String,
    message: String
) {
    val priority = when (level) {
        LogLevel.DEBUG -> Log.DEBUG
        LogLevel.ERROR -> Log.ERROR
        LogLevel.WARNING -> Log.WARN
        LogLevel.INFO -> Log.INFO
        LogLevel.ASSERT -> Log.ASSERT
        LogLevel.VERBOSE -> Log.VERBOSE
    }

    Log.println(priority, tag, message)
}