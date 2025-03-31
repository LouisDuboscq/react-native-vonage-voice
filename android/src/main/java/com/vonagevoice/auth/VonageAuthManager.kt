package com.vonagevoice.auth

class VonageAuthManager(private val voiceClient: VoiceClient) : AuthManager {
  override fun login(jwt: String, region: String?): Result<LoginResponse> {
    return try {
      voiceClient.login(jwt, region)
      Result.success(LoginResponse(true))
    } catch (e: Exception) {
      Result.failure(e)
    }
  }

  override fun logout(): Result<Unit> {
    return try {
      voiceClient.logout()
      Result.success(Unit)
    } catch (e: Exception) {
      Result.failure(e)
    }
  }

  override fun registerVonageVoipToken(token: String, isSandbox: Boolean): Result<String?> {
    return try {
      voiceClient.registerVoipToken(token, isSandbox)
      Result.success("token-registered")
    } catch (e: Exception) {
      Result.failure(e)
    }
  }
}
