package com.OxeBank.banking.repository.model

import com.OxeBank.banking.domain.Credito
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.math.BigDecimal

@Entity(name = "produto")
data class CreditoEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    val nome: String,
    val descricao: String,
    val preco: BigDecimal,
    val categoria: String
){

    fun paraDominio(): Credito {
        return Credito(
            id = id,
            nome = nome!!,
            descricao = descricao!!,
            preco = preco!!,
            categoria = categoria!!
        )
    }

    companion object{
        fun doDominio(credito: Credito): CreditoEntity {
            return CreditoEntity(
            id = credito.id,
            nome = credito.nome,
            descricao = credito.descricao,
            preco = credito.preco,
            categoria = credito.categoria
            )
        }
    }

}



