package com.OxeBank.OxeBanking.daos.dto

import com.OxeBank.OxeBanking.models.CartaoCredito

class CartaoCreditoDTO(
    var id: Int?,
    val nome: String,
    val descricao: String
) {
    fun paraDominio(): CartaoCredito{
        return CartaoCredito(
            id = null,
            nome = nome,
            descricao = descricao
        )
    }
}