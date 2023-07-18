package com.attafitamim.seer.libs.core.model

data class LogEntry(
    val id: String,
    val dateInMillis: Long,
    val tag: String,
    val level: LogLevel = LogLevel.DEBUG,
    val data: Data? = null
) {

    data class Data(
        val description: String? = null,
        val parameters: List<LogParameter>? = null,
        val jsonPayload: String? = null,
        val note: String? = null
    )
}
