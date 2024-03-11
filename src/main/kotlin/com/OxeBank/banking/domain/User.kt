package com.OxeBank.banking.domain

import java.math.BigDecimal

data class User (
    var nome: String,
    var id: Long?,
    val vetorClasse: ArrayList<Credito>
)

