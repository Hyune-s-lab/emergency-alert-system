package com.hyunec.domain.merchant.service

import com.hyunec.domain.merchant.entity.MerchantEntity
import com.hyunec.domain.merchant.repository.MerchantRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MerchantRegisterService(val merchantRepository: MerchantRepository) {

    @Transactional
    fun register(mid: String, webhookKey: String): Long {
        check(!merchantRepository.existsByMid(mid))
        return merchantRepository.save(
            MerchantEntity(
                mid = mid,
                slackWebhookKey = webhookKey
            )
        ).merchantId!!
    }
}
