package com.hyunec.web.request

data class RegisterMerchantRequest(
    val mid: String,
    val webhookKey: String
)
