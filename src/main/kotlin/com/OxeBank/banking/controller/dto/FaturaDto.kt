package com.OxeBank.banking.controller.dto

import com.OxeBank.banking.domain.User
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

class FaturaDto(
    val id: Long? = null,
    @field:NotBlank(message = "o id é obrigatorio")
    @field:NotNull(message = "o valor é obrigatorio")
    val name: String,
    val precofatura: Long? = null,

) {

    fun paraDominio(): User? {
        return precofatura?.let {
            User(
                idcartao = null,
                name = name,
                precofatura = it
            )
        }
    }




}