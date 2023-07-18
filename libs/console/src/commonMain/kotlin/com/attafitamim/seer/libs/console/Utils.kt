package com.attafitamim.seer.libs.console

fun StringBuilder.appendLineIfNotEmpty(data: String?) {
    if (data.isNullOrBlank()) return
    appendLine(data)
}