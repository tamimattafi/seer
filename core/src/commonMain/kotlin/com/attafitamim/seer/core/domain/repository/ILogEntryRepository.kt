package com.attafitamim.seer.core.domain.repository

import com.attafitamim.seer.core.domain.model.LogEntry

interface ILogEntryRepository {

    suspend fun addLogEntry(entry: LogEntry)

    suspend fun addLogEntries(entries: List<LogEntry>)

    suspend fun getLogEntry(id: String): LogEntry

    suspend fun getLogEntries(limit: Int, offset: Int): List<LogEntry>

    suspend fun deleteLogEntry(id: String)

    suspend fun deleteAllLogEntries()
}
