package com.hyunec.domain.merchant.entity

import com.hyunec.domain.merchant.constant.MerchantStatusType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table


@Table(name = "Merchant")
@Entity
class MerchantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var merchantId: Long? = null

    var status: MerchantStatusType = MerchantStatusType.LIVE
    var slackWebhookKey: String? = null
}
