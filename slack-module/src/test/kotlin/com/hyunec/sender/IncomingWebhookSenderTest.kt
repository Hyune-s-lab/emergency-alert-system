package com.hyunec.sender

import com.hyunec.sender.stub.IncomingWebhookSenderFailedStub
import com.hyunec.sender.stub.IncomingWebhookSenderSuccessStub
import com.navercorp.fixturemonkey.FixtureMonkey
import com.navercorp.fixturemonkey.LabMonkey
import com.navercorp.fixturemonkey.kotlin.giveMeOne
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import java.net.http.HttpTimeoutException

@DisplayName("IncomingWebhookSenderTest")
internal class IncomingWebhookSenderTest : BehaviorSpec() {
    private val msg = "ok"
    private val successStub = IncomingWebhookSenderSuccessStub(msg)
    private val exception = HttpTimeoutException("stub exception")
    private val failedStub = IncomingWebhookSenderFailedStub(exception)

    private val labMonkey: LabMonkey = FixtureMonkey.labMonkey()

    init {
        this.Given("dummy 정보 준비") {
            val webhookKey = labMonkey.giveMeOne<String>()
            val body = labMonkey.giveMeOne<Map<String, String>>()

            When("slack 발송 - successStub") {
                successStub.send(webhookKey, body)
                    .subscribe { it shouldBe msg }
            }

            When("slack 발송 - failedStub") {
                shouldThrow<RuntimeException> {
                    failedStub.send(webhookKey, body)
                        .doOnError {
                            println("### $it.localizedMessage")
                            it.localizedMessage shouldBe exception.localizedMessage
                        }
                        .block()
                }
            }
        }
    }
}
