package com.hyunec.web

import com.hyunec.domain.MerchantService
import com.hyunec.web.request.RegisterMerchantRequest
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@Tag(name = "상점", description = "merchant")
@RestController
class MerchantController(val merchantService: MerchantService) {

    @Operation(summary = "상점 등록")
    @PostMapping("/merchant")
    fun registerMerchant(@RequestBody request: RegisterMerchantRequest) {
        merchantService.register(request.mid, request.webhookKey)
    }
}
