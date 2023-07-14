package com.attafitamim.seer.core.domain.interaction

import com.attafitamim.seer.core.domain.repository.ILogEntryRepository

class GetLogEntries(
    private val logEntryRepository: ILogEntryRepository
) {
    suspend operator fun invoke(limit: Int, offset: Int) =
        logEntryRepository.getLogEntries(limit, offset)
}
