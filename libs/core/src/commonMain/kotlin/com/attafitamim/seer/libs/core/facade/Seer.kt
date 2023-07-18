package com.attafitamim.seer.libs.core.facade

import com.attafitamim.seer.libs.core.logger.ISeerLogger
import com.attafitamim.seer.libs.core.model.LogEntry
import com.attafitamim.seer.libs.core.model.LogLevel
import com.attafitamim.seer.libs.core.model.LogParameter
import com.benasher44.uuid.uuid4
import kotlin.jvm.Synchronized
import kotlin.jvm.Volatile
import kotlin.native.concurrent.ThreadLocal
import kotlinx.datetime.Clock

class Seer(
    private val loggers: List<ISeerLogger>
) : ISeer {

    override fun log(
        tag: String,
        level: LogLevel,
        description: String?,
        parameters: List<LogParameter>?,
        jsonPayload: String?,
        note: String?
    ) {
        val data = LogEntry.Data(
            description,
            parameters,
            jsonPayload,
            note
        )

        log(tag, level, data)
    }

    override fun log(
        tag: String,
        level: LogLevel,
        data: LogEntry.Data?
    ) {
        val id = uuid4().toString()
        val date = Clock.System.now().toEpochMilliseconds()

        val logEntry = LogEntry(
            id,
            date,
            tag,
            level,
            data
        )

        log(logEntry)
    }

    override fun log(entry: LogEntry) {
        loggers.forEach { logger ->
            logger.log(entry)
        }
    }

    @ThreadLocal
    companion object : ISeer {

        @Volatile
        private var instance: ISeer? = null

        @Synchronized
        fun init(loggers: List<ISeerLogger>) {
            require(loggers.isNotEmpty())
            instance = Seer(loggers)
        }

        @Synchronized
        fun init(logger: ISeerLogger) {
            val loggers = listOf(logger)
            instance = Seer(loggers)
        }

        @Synchronized
        fun init(seer: ISeer) {
            instance = seer
        }

        @Synchronized
        fun getInstance(): ISeer =
            requireNotNull(instance)

        @Synchronized
        fun isInitialized(): Boolean = instance != null

        @Synchronized
        fun release() {
            instance = null
        }

        override fun log(
            tag: String,
            level: LogLevel,
            description: String?,
            parameters: List<LogParameter>?,
            jsonPayload: String?,
            note: String?
        ) {
            getInstance().log(tag, level, description, parameters, jsonPayload, note)
        }

        override fun log(tag: String, level: LogLevel, data: LogEntry.Data?) {
            getInstance().log(tag, level, data)
        }

        override fun log(entry: LogEntry) {
            getInstance().log(entry)
        }
    }
}
