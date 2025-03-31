package com.vonagevoice.auth

interface AuthManager {
    fun login(jwt: String, region: String?): Result<LoginResponse>

    fun logout(): Result<Unit>

    fun registerVonageVoipToken(token: String, isSandbox: Boolean): Result<String?>
}
