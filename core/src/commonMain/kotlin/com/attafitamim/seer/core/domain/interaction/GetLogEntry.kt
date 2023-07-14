package com.attafitamim.seer.core.domain.interaction

import com.attafitamim.seer.core.domain.repository.ILogEntryRepository

class GetLogEntry(
    private val logEntryRepository: ILogEntryRepository
) {
    suspend operator fun invoke(id: String) =
        logEntryRepository.getLogEntry(id)
}
