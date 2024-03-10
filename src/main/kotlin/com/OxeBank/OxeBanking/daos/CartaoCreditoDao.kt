package com.OxeBank.OxeBanking.daos

import com.OxeBank.OxeBanking.daos.dto.CartaoCreditoDTO
import com.OxeBank.OxeBanking.models.CartaoCredito
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CartaoCreditoDao {

    @PostMapping("/v1/cartaocredito")
    fun createCreditCard(@RequestBody cartaoCreditoDTO : CartaoCreditoDTO): CartaoCredito {
        return cartaoCreditoDTO.paraDominio()

    }
}