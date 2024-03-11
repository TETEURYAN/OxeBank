package com.OxeBank.banking.repository

import com.OxeBank.banking.repository.model.CreditoEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CreditRepository: JpaRepository<CreditoEntity, Long> {

    fun findByNome(pesquisa: String): CreditoEntity

}