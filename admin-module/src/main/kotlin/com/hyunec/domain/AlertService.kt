package com.hyunec.domain

import com.hyunec.constant.ProviderType
import com.hyunec.sender.IncomingWebhookSender
import org.springframework.stereotype.Service

@Service
class AlertService(private val webhookSender: IncomingWebhookSender) {

    fun send(mid: String, types: List<ProviderType>, contents: String) {
        if (types.contains(ProviderType.SLACK)) {
            // TODO mid 에 매칭되는 webhookKey 가져오기
            val webhookKey = "xxxxxxx"

            webhookSender.send(webhookKey, mapOf("text" to contents))
                // TODO alert 발송 실패 event. db 기록
                .onErrorContinue { error: Throwable, obj: Any -> println("### error: $error $obj") }
                // TODO alert 발송 성공 event. db 기록
                .subscribe { msg -> println("### success: $msg") }
        }
    }
}
