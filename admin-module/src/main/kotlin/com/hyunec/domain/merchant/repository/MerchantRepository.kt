package com.hyunec.domain.merchant.repository

import com.hyunec.domain.merchant.entity.MerchantEntity

interface MerchantRepository {

    fun save(merchantEntity: MerchantEntity): MerchantEntity
}
