package com.vonagevoice

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Callback

class NewVonageVoiceModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

  private val authManager: AuthManager by inject()
  private val callManager: CallManager by inject()
  private val deviceManager: DeviceManager by inject()

  override fun getName(): String {
    return "VonageVoiceModule"
  }

  @ReactMethod
  fun login(jwt: String, region: String?, callback: Callback) {
    val result = authManager.login(jwt, region)
    if (result.isSuccess) {
      callback.invoke(null, result.getOrNull())
    } else {
      callback.invoke(result.exceptionOrNull()?.message)
    }
  }

  @ReactMethod
  fun logout(callback: Callback) {
    val result = authManager.logout()
    if (result.isSuccess) {
      callback.invoke(null, result.getOrNull())
    } else {
      callback.invoke(result.exceptionOrNull()?.message)
    }
  }

  @ReactMethod
  fun answerCall(callId: String, callback: Callback) {
    val result = callManager.answerCall(callId)
    if (result.isSuccess) {
      callback.invoke(null, result.getOrNull())
    } else {
      callback.invoke(result.exceptionOrNull()?.message)
    }
  }
}
