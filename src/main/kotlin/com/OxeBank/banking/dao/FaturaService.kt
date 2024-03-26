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

    fun salvar(faturaDto: FaturaDto): Fatura? {
        val alimento = faturaDto.paraDominio()
        return alimento?.let { FaturaEntity.doDominio(it) }?.let { faturaRepository.save(it).paraDominio() }
    }

    fun buscarTodos(): List<Fatura> {
        return faturaRepository.findAll().map { it.paraDominio() }
    }

    fun remover(credito: Credito) {
        var valor = credito.preco
        var idUser = credito.iduser

        var usuarios: List<Fatura> = buscarTodos()
        var user: Fatura? = null
        for(i in usuarios){
            if(i.idcartao == idUser){
                i.precofatura -= valor!!.toLong()
                user = i
                break;
            }
        }

        user?.let { FaturaEntity.doDominio(it) }?.let { faturaRepository.save(it).paraDominio() }
    }

    fun atualizarUser(creditoDto: CreditoDto): Fatura? {
        var idUser = creditoDto.iduser

        var arr: List<Fatura> = buscarTodos()
        var ans: Fatura? = null

        for(i in arr){
            if(i.idcartao == idUser){
                ans = i
                break
            }
        }

        if(ans != null){
            ans.precofatura += creditoDto.preco!!.toLong()
        }

        return ans?.let { FaturaEntity.doDominio(it) }?.let { faturaRepository.save(it).paraDominio() }
    }

}