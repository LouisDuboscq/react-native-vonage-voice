package com.vonagevoice.controller.call

interface CallManager {
    fun answerCall(callId: String): Result<Unit>
    fun rejectCall(callId: String): Result<Unit>
    fun hangup(callId: String): Result<Unit>
    fun mute(callId: String): Result<Unit>
    fun unmute(callId: String): Result<Unit>
    fun reconnectCall(callId: String): Result<Unit>
}
