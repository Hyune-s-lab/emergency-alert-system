package com.hyunec.web

import com.hyunec.domain.AlertService
import com.hyunec.web.request.AlertSendRequest
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@Tag(name = "알람", description = "alert")
@RestController
class AlertController(val alertService: AlertService) {

    @Operation(summary = "알람 발송")
    @PostMapping("/alert")
    fun send(@RequestBody request: AlertSendRequest) {
        // TODO alert 발송 요청 event. db 기록

        alertService.send(request.mid, request.types, request.contents)
    }
}
