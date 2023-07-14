package com.attafitamim.seer.core.domain.interaction

import com.attafitamim.seer.core.domain.model.LogEntry
import com.attafitamim.seer.core.domain.repository.ILogEntryRepository

class AddLogEntries(
    private val logEntryRepository: ILogEntryRepository
) {
    suspend operator fun invoke(entries: List<LogEntry>) =
        logEntryRepository.addLogEntries(entries)
}
