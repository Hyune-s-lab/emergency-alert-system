package com.hyunec.domain.merchant.repository

import com.hyunec.domain.merchant.entity.MerchantEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface MerchantJpaDao : JpaRepository<MerchantEntity, UUID> {

    fun findByMid(mid: String): MerchantEntity?
}
