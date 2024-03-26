package com.OxeBank.banking.dao

import com.OxeBank.banking.controller.dto.CreditoDto
import com.OxeBank.banking.controller.dto.FaturaDto
import com.OxeBank.banking.domain.Credito
import com.OxeBank.banking.domain.Fatura
import com.OxeBank.banking.repository.FaturaRepository
import com.OxeBank.banking.repository.model.CreditoEntity
import com.OxeBank.banking.repository.model.FaturaEntity
import org.springframework.stereotype.Service

@Service
class FaturaService(
    private val faturaRepository: FaturaRepository
){

    fun salvar(faturaDto: FaturaDto): Fatura {
        val alimento = faturaDto.paraDominio()
        return  faturaRepository.save(FaturaEntity.doDominio(alimento)).paraDominio()
    }

    fun buscarTodos(): List<Fatura> {
        return faturaRepository.findAll().map { it.paraDominio() }
    }
}