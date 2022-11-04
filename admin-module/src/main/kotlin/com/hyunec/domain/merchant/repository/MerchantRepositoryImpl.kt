package com.hyunec.domain.merchant.repository

import com.hyunec.domain.merchant.entity.MerchantEntity
import org.springframework.stereotype.Repository

@Repository
class MerchantRepositoryImpl(
    val merchantJpaDao: MerchantJpaDao
) : MerchantRepository {
    override fun findAll(): List<MerchantEntity> {
        return merchantJpaDao.findAll()
    }

    override fun findByMid(mid: String): MerchantEntity? {
        return merchantJpaDao.findByMid(mid)
    }

    override fun existsByMid(mid: String): Boolean {
        return merchantJpaDao.existsByMid(mid)
    }

    override fun save(merchantEntity: MerchantEntity): MerchantEntity {
        return merchantJpaDao.save(merchantEntity)
    }
}
