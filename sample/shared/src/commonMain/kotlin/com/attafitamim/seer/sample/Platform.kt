package com.attafitamim.seer.sample

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform