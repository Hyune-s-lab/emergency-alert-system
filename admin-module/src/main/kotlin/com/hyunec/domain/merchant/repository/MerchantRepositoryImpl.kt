package com.hyunec.domain.merchant.repository

import com.hyunec.domain.merchant.entity.MerchantEntity
import org.springframework.stereotype.Repository

@Repository
class MerchantRepositoryImpl(
    val merchantJpaDao: MerchantJpaDao
) : MerchantRepository {
    override fun save(merchantEntity: MerchantEntity): MerchantEntity? {
        return merchantJpaDao.save(merchantEntity)
    }
}
