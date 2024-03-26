package com.OxeBank.banking.repository

import com.OxeBank.banking.repository.model.CreditoEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.transaction.annotation.Transactional

interface CreditRepository: JpaRepository<CreditoEntity, Long> {

    fun findByNome(pesquisa: String): CreditoEntity

}