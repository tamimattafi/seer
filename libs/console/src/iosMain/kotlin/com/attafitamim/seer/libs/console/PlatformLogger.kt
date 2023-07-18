package com.attafitamim.seer.libs.console

import com.attafitamim.seer.libs.core.model.LogLevel

actual fun log(
    level: LogLevel,
    tag: String,
    message: String
) {
    val logText = buildString {
        appendLineIfNotEmpty(level.toString())
        appendLineIfNotEmpty(tag)
        appendLineIfNotEmpty(message)
    }

    print(logText)
}
