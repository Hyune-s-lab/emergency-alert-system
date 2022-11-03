package com.hyunec.domain.merchant.service

import com.hyunec.domain.merchant.repository.MerchantRepository
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("test")
@DisplayName("MerchantRegisterServiceTest")
@SpringBootTest
internal class MerchantRegisterServiceTest : BehaviorSpec() {
    override fun extensions() = listOf(SpringExtension)

    @Autowired
    private lateinit var merchantRegisterService: MerchantRegisterService

    @Autowired
    private lateinit var merchantRepository: MerchantRepository

    init {
        this.Given("상점 정보 준비")
        {
            val mid = "M001"
            val key = "key1"

            When("상점 생성") {
                val id = withContext(Dispatchers.IO) {
                    merchantRegisterService.register(mid, key)
                }

                Then("생성 확인") {
                    id shouldNotBe null
                    val findMerchant = merchantRepository.findByMid(mid)
                    check(findMerchant != null)
                    findMerchant.mid shouldBe mid
                    findMerchant.slackWebhookKey shouldBe key
                }
            }
        }
    }
}
