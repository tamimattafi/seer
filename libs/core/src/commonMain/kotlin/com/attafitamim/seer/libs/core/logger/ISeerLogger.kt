package com.attafitamim.seer.libs.core.logger

import com.attafitamim.seer.libs.core.model.LogEntry

interface ISeerLogger {
    fun log(logEntry: LogEntry)
}
