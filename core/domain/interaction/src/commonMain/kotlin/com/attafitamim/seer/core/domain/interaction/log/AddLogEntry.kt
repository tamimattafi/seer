package com.attafitamim.seer.core.domain.interaction.log

import com.attafitamim.seer.core.domain.model.log.LogEntry
import com.attafitamim.seer.core.domain.repository.log.ILogEntryRepository

class AddLogEntry(
    private val logEntryRepository: ILogEntryRepository
) {
    suspend operator fun invoke(entry: LogEntry) =
        logEntryRepository.addLogEntry(entry)
}
