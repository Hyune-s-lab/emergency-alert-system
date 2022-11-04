package com.hyunec.sender.stub

import reactor.core.publisher.Mono

class IncomingWebhookSenderFailedStub(private val exception: java.lang.Exception) {
    fun send(webhookKey: String, body: Map<String, String>): Mono<String> {
        return Mono.error(exception)
    }
}
