package com.hyunec.sender.stub

import reactor.core.publisher.Mono

class IncomingWebhookSenderSuccessStub(private val msg: String) {
    fun send(webhookKey: String, body: Map<String, String>): Mono<String> {
        return Mono.just(msg)
    }
}
