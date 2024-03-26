package com.OxeBank.banking.controller.dto

import com.OxeBank.banking.domain.Credito
import com.OxeBank.banking.domain.Fatura
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.math.BigDecimal

class FaturaDto(
    val id: Long? = null,
    @field:NotBlank(message = "o id é obrigatorio")
    @field:NotNull(message = "o valor é obrigatorio")
    val name: String,
    val precofatura: Long? = null,

) {

    fun paraDominio(): Fatura {
        return Fatura(
            idcartao = null,
            name = name,
            precofatura = precofatura
        )
    }




}