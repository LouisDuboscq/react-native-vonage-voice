package com.vonagevoice.push

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class VonagePushMessageService : FirebaseMessagingService() {

    private val callController: CallController by inject()

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        // Register new token with Vonage
        callController.registerPushToken(token) { _, _ -> }
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        if (message.data.containsKey("vonage_call")) {
            // Handle incoming call push notification
            callController.client.processCallInvitePushData(message.data)
        }
    }
}
