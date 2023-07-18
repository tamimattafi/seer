package com.attafitamim.seer.libs.console

import com.attafitamim.seer.libs.core.model.LogLevel

expect fun log(level: LogLevel, tag: String, message: String)
