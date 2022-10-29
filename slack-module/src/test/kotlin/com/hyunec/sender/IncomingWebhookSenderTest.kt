package com.hyunec.sender

import io.kotest.core.annotation.Ignored
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.junit.jupiter.api.DisplayName
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.web.reactive.function.client.WebClient

@Ignored // 필요시 Ignored 제거
@DisplayName("IncomingWebhookSenderTest")
@SpringBootTest
internal class IncomingWebhookSenderTest : BehaviorSpec({
    Given("set test data") {
        val sender = IncomingWebhookSender(
            WebClient.builder().baseUrl("https://hooks.slack.com/services/").build()
        )

        // webhookKey 를 넣어야 합니다.
        val webhookKey = "xxxxxxxx/xxxxxxxx/xxxxxxxxxxxxxxxx"
        val body = mapOf("text" to "Hello, World!")

        When("request by webhookSender") {
            val response = withContext(Dispatchers.IO) {
                sender.send(webhookKey, body).block()
            }

            Then("response is ok") {
                response shouldBe "ok"
            }
        }
    }
})
