package com.OxeBank.banking.controller.dto

import com.OxeBank.banking.domain.Credito
import jakarta.validation.constraints.*
import java.math.BigDecimal

class CreditoDto(
    var iduser: Long,

    @field:NotBlank(message = "o nome é obrigatorio")
    @field:Size(min = 3, max = 20, message = "o nome deve ter mais que 3 e menos que 20 caracteres")
    val nome: String? = null,
    @field:NotBlank(message = "a descrição é obrigatorio")
    val descricao: String? = null,
    @field:NotNull(message = "o preço é obrigatorio")
    @field:Min(value = 0, message = "o preço deve ser maior que zero")
    var preco: BigDecimal? = null,
    @field:NotBlank(message = "a categoria é obrigatorio")
    @field:Size(max = 20, message = "a categoria deve ter menos que 20 caracteres")
    val categoria: String? = null
) {
    fun paraDominio(): Credito {
        return Credito(
            id = null,
            iduser = iduser!!,
            nome = nome!!,
            descricao = descricao!!,
            preco = preco!!,
            categoria = categoria!!
        )
    }
}