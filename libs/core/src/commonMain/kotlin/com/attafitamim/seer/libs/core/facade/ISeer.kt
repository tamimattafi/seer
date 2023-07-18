package com.attafitamim.seer.libs.core.facade

import com.attafitamim.seer.libs.core.model.LogEntry
import com.attafitamim.seer.libs.core.model.LogLevel
import com.attafitamim.seer.libs.core.model.LogParameter

interface ISeer {

    fun log(
        tag: String,
        level: LogLevel = LogLevel.DEBUG,
        description: String? = null,
        parameters: List<LogParameter>? = null,
        jsonPayload: String? = null,
        note: String? = null
    )

    fun log(
        tag: String,
        level: LogLevel = LogLevel.DEBUG,
        data: LogEntry.Data? = null
    )

    fun log(entry: LogEntry)
}
