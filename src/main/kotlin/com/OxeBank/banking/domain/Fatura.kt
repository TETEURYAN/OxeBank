package com.OxeBank.banking.domain

import com.OxeBank.banking.service.CreditoService

data class Fatura (
    var idcartao: Long?,
    var name: String,
    val precofatura: Long?
)

