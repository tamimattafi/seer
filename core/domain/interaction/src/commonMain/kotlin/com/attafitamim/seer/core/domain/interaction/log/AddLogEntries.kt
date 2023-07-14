package com.attafitamim.seer.core.domain.interaction.log

import com.attafitamim.seer.core.domain.model.log.LogEntry
import com.attafitamim.seer.core.domain.repository.log.ILogEntryRepository

class AddLogEntries(
    private val logEntryRepository: ILogEntryRepository
) {
    suspend operator fun invoke(entries: List<LogEntry>) =
        logEntryRepository.addLogEntries(entries)
}
