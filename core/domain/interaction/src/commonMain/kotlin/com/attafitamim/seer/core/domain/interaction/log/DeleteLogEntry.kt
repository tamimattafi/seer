package com.attafitamim.seer.core.domain.interaction.log

import com.attafitamim.seer.core.domain.repository.log.ILogEntryRepository

class DeleteLogEntry(
    private val logEntryRepository: ILogEntryRepository
) {
    suspend operator fun invoke(id: String) =
        logEntryRepository.deleteLogEntry(id)
}
