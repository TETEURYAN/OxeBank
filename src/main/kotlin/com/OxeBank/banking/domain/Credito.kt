package com.OxeBank.banking.domain

import java.math.BigDecimal

data class Credito(
    var id: Long?,
    var iduser: Long?,
    val nome: String,
    val descricao: String,
    val preco: BigDecimal,
    val categoria: String
)
