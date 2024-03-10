package com.OxeBank.OxeBanking.services

import com.OxeBank.OxeBanking.daos.dto.CartaoCreditoDTO
import com.OxeBank.OxeBanking.models.CartaoCredito
import com.OxeBank.OxeBanking.repository.CartaoRepository
import org.springframework.stereotype.Service

@Service
class CartaoCreditoService(
     val cartaoRepository: CartaoRepository
) {
    fun save(cartaoCreditoDTO: CartaoCreditoDTO): CartaoCredito{
        return  cartaoRepository.save(cartaoCreditoDTO.paraDominio())
    }
}