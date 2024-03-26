package com.OxeBank.banking.repository.model

import com.OxeBank.banking.domain.Fatura
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "fatura")
class FaturaEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    var nome: String,
    val valor: Long?
){

fun paraDominio(): Fatura{
    return Fatura(
        idcartao = id,
        name = nome,
        precofatura = valor!!,
    )
}
    companion object{
        fun doDominio(fatura: Fatura): FaturaEntity{
            return FaturaEntity(
                id = fatura.idcartao,
                nome = fatura.name,
                valor = fatura.precofatura
            )
        }
    }
}
