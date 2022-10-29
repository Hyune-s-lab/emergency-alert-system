package com.hyunec.web

import com.hyunec.domain.AlertService
import com.hyunec.web.request.SendAlertRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AlertController(val alertService: AlertService) {

    @PostMapping("/alert")
    fun sendAlert(@RequestBody request: SendAlertRequest) {
        // TODO alert 발송 요청 event. db 기록

        alertService.send(request.mid, request.types, request.contents)
    }
}
