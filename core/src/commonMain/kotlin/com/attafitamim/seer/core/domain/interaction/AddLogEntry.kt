package com.attafitamim.seer.core.domain.interaction

import com.attafitamim.seer.core.domain.model.LogEntry
import com.attafitamim.seer.core.domain.repository.ILogEntryRepository

class AddLogEntry(
    private val logEntryRepository: ILogEntryRepository
) {
    suspend operator fun invoke(entry: LogEntry) =
        logEntryRepository.addLogEntry(entry)
}
