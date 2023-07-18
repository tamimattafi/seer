package com.attafitamim.seer.libs.console

import com.attafitamim.seer.libs.core.logger.ISeerLogger
import com.attafitamim.seer.libs.core.model.LogEntry

class ConsoleLogger : ISeerLogger {

    override fun log(logEntry: LogEntry) {
        val parameters = buildString {
            logEntry.data?.parameters?.forEach { parameter ->
                append(parameter.label, "=", parameter.value)
                appendLine()
            }
        }.trimIndent()

        val message = buildString {
            appendLineIfNotEmpty(logEntry.data?.description)
            appendLineIfNotEmpty(parameters)
            appendLineIfNotEmpty(logEntry.data?.jsonPayload)
            appendLineIfNotEmpty(logEntry.data?.note)
        }

        log(logEntry.level, logEntry.tag, message)
    }
}
