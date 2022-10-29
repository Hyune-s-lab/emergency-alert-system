package com.hyunec.web.request

import com.hyunec.constant.ProviderType

data class SendAlertRequest(
    val mid: String,
    val types: List<ProviderType>,
    val contents: String
)
