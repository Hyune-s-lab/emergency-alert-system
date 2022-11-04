package com.hyunec.domain.merchant.repository

import com.hyunec.domain.merchant.entity.MerchantEntity

interface MerchantRepository {

    fun findAll(): List<MerchantEntity>
    fun findByMid(mid: String): MerchantEntity?
    fun existsByMid(mid: String): Boolean
    fun save(merchantEntity: MerchantEntity): MerchantEntity
}
