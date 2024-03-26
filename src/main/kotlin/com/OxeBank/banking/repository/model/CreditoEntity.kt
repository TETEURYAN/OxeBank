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
    var iduser: Long?,
    val nome: String,
    val descricao: String,
    val preco: BigDecimal,
    val categoria: String
){

    fun paraDominio(): Credito {
        return Credito(
            id = id,
            iduser = iduser!!,
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
            iduser = credito.iduser,
            nome = credito.nome,
            descricao = credito.descricao,
            preco = credito.preco,
            categoria = credito.categoria
            )
        }
    }

}



