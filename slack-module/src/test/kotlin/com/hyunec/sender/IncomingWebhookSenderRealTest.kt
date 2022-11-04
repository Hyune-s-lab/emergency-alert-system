package com.hyunec.sender

import com.hyunec.config.WebClientConfigure
import io.kotest.core.annotation.Ignored
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@Ignored // 필요시 Ignored 제거
@DisplayName("IncomingWebhookSenderRealTest")
@SpringBootTest(classes = [WebClientConfigure::class, IncomingWebhookSender::class])
internal class IncomingWebhookSenderRealTest : BehaviorSpec() {
    override fun extensions() = listOf(SpringExtension)

    @Autowired
    lateinit var sender: IncomingWebhookSender

    init {
        this.Given("set test data") {
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
    }
}
