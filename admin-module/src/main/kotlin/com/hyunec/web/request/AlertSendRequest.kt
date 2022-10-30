package com.hyunec.web.request

import com.hyunec.constant.ProviderType

data class AlertSendRequest(
    val mid: String,
    val types: List<ProviderType>,
    val contents: String
)
