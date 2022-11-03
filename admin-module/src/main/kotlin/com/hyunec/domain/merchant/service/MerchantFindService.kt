package com.hyunec.domain.merchant.service

import com.hyunec.domain.merchant.entity.MerchantEntity
import com.hyunec.domain.merchant.repository.MerchantRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@Service
class MerchantFindService(val merchantRepository: MerchantRepository) {

    fun findAll(): List<MerchantEntity> {
        return merchantRepository.findAll()
    }

    fun findByMid(mid: String): List<MerchantEntity> {
        return merchantRepository.findAll()
    }
}
