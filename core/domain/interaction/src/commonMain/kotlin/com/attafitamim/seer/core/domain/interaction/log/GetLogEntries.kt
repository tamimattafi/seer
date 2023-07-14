package com.attafitamim.seer.core.domain.interaction.log

import com.attafitamim.seer.core.domain.repository.log.ILogEntryRepository

class GetLogEntries(
    private val logEntryRepository: ILogEntryRepository
) {
    suspend operator fun invoke(limit: Int, offset: Int) =
        logEntryRepository.getLogEntries(limit, offset)
}
