package com.hyunec.domain.merchant.service

import com.hyunec.domain.merchant.repository.MerchantRepository
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("test")
@DisplayName("MerchantRegisterServiceTest")
@SpringBootTest
internal class MerchantRegisterServiceTest(
    val merchantRegisterService: MerchantRegisterService,
    val merchantRepository: MerchantRepository,
) : BehaviorSpec() {
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

            When("같은 mid 로 상점 생성") {
                shouldThrow<IllegalStateException> {
                    merchantRegisterService.register(mid, key)
                }
            }
        }
    }
}
