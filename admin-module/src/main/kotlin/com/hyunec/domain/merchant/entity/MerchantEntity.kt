package com.hyunec.domain.merchant.entity

import com.hyunec.domain.merchant.constant.MerchantStatusType
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table


@Table(name = "Merchant")
@Entity
class MerchantEntity(
    var slackWebhookKey: String? = null
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val merchantId: Long? = null

    @Enumerated(EnumType.STRING)
    val status = MerchantStatusType.LIVE
    lateinit var mid: String

    constructor(mid: String, slackWebhookKey: String) : this(slackWebhookKey = slackWebhookKey) {
        this.mid = mid
    }
}
