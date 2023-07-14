package com.attafitamim.seer.core.domain.interaction.log

import com.attafitamim.seer.core.domain.repository.log.ILogEntryRepository

class DeleteAllLogEntries(
    private val logEntryRepository: ILogEntryRepository
) {
    suspend operator fun invoke() =
        logEntryRepository.deleteAllLogEntries()
}
