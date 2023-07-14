package com.attafitamim.seer.core.domain.model.log

data class LogEntry(
    val id: String,
    val dateInMillis: Long,
    val tag: String,
    val level: LogLevel,
    val description: String?,
    val parameters: List<LogParameter>?,
    val jsonPayload: String?,
    val note: String?,
    val isBookmarked: Boolean
)
