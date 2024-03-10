package com.OxeBank.OxeBanking.repository

import com.OxeBank.OxeBanking.models.CartaoCredito
import org.springframework.stereotype.Component

@Component
class memory(): CartaoRepository {
    private val cartaoLista: MutableList<CartaoCredito>
    private var indexedValue: Int = 0

    init{
        cartaoLista = ArrayList()

    }
    override fun save(cartaoCredito: CartaoCredito): CartaoCredito {
        indexedValue
        cartaoCredito.id = indexedValue
        cartaoLista.add(cartaoCredito)
        return cartaoCredito


    }

}