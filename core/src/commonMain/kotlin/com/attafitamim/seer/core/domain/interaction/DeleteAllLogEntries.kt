package com.attafitamim.seer.core.domain.interaction

import com.attafitamim.seer.core.domain.repository.ILogEntryRepository

class DeleteAllLogEntries(
    private val logEntryRepository: ILogEntryRepository
) {
    suspend operator fun invoke() =
        logEntryRepository.deleteAllLogEntries()
}
