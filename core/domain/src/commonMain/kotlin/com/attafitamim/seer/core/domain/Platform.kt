package com.attafitamim.seer.core.domain

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform