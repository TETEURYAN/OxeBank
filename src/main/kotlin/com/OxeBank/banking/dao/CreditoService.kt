package com.OxeBank.banking.service

import com.OxeBank.banking.controller.dto.CreditoDto
import com.OxeBank.banking.domain.Credito
import com.OxeBank.banking.repository.CreditRepository
import com.OxeBank.banking.repository.FaturaRepository
import com.OxeBank.banking.repository.model.CreditoEntity
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreditoService(
    private val creditRepository: CreditRepository,
    private val faturaRepository: FaturaRepository
) {

    fun salvar(creditoDto: CreditoDto): Credito {
        val alimento = creditoDto.paraDominio()
        return  creditRepository.save(CreditoEntity.doDominio(alimento)).paraDominio()
    }

    fun buscarTodos(): List<Credito> {
        return creditRepository.findAll().map { it.paraDominio() }
    }

    fun buscarComFiltro(pesquisa: String): Credito {
        val id = pesquisa.toLongOrNull()
        val alimentoEntity = if(id == null){
             creditRepository.findByNome(pesquisa)
        }else{
             creditRepository.findById(id).orElseThrow()
        }
        return alimentoEntity.paraDominio()
    }

    fun deletar(id: Long) {
        creditRepository.deleteById(id)
    }

    fun atualizar(id: Long, creditoDto: CreditoDto): Credito? {
        val alimento = creditoDto.paraDominio().copy(id = id)
        return creditRepository.save(CreditoEntity.doDominio(alimento)).paraDominio()
    }

}