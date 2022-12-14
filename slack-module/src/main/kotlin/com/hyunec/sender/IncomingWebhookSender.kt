package com.hyunec.sender

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono


@Component
class IncomingWebhookSender(private val webClient: WebClient) {

    fun send(webhookKey: String, body: Map<String, String>): Mono<String> {
        return webClient.post()
            .uri(webhookKey)
            .body(BodyInserters.fromValue(body))
            .retrieve()
            .bodyToMono(String::class.java)
    }
}
