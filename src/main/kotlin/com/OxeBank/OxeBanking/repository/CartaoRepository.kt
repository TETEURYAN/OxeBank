package com.OxeBank.OxeBanking.repository

import com.OxeBank.OxeBanking.models.CartaoCredito

interface CartaoRepository {
    fun save(cartaoCredito: CartaoCredito): CartaoCredito
}