package com.attafitamim.seer.core

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform