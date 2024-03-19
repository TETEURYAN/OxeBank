package com.OxeBank.banking.domain

import com.OxeBank.banking.service.CreditoService

data class Fatura (
    var idCartao: Long?,
//    var vetorClasse: ArrayList<Credito>? = null,
    val credito: CreditoService?,
){
    fun buscarFatura(): List<Credito>? {
        return credito?.buscarTodos()
    }
}

