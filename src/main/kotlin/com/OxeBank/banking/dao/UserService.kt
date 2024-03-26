package com.OxeBank.banking.dao

import com.OxeBank.banking.controller.dto.CreditoDto
import com.OxeBank.banking.controller.dto.FaturaDto
import com.OxeBank.banking.domain.Credito
import com.OxeBank.banking.domain.User
import com.OxeBank.banking.repository.UserRepository
import com.OxeBank.banking.repository.model.UserEntity
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
){

    fun salvar(faturaDto: FaturaDto): User? {
        val alimento = faturaDto.paraDominio()
        return alimento?.let { UserEntity.doDominio(it) }?.let { userRepository.save(it).paraDominio() }
    }

    fun buscarTodos(): List<User> {
        return userRepository.findAll().map { it.paraDominio() }
    }

    fun remover(credito: Credito) {
        var valor = credito.preco
        var idUser = credito.iduser

        var usuarios: List<User> = buscarTodos()
        var user: User? = null
        for(i in usuarios){
            if(i.idcartao == idUser){
                i.precofatura -= valor!!.toLong()
                user = i
                break;
            }
        }

        user?.let { UserEntity.doDominio(it) }?.let { userRepository.save(it).paraDominio() }
    }

    fun atualizarUser(creditoDto: CreditoDto): User? {
        var idUser = creditoDto.iduser

        var arr: List<User> = buscarTodos()
        var ans: User? = null

        for(i in arr){
            if(i.idcartao == idUser){
                ans = i
                break
            }
        }

        if(ans != null){
            ans.precofatura += creditoDto.preco!!.toLong()
        }

        return ans?.let { UserEntity.doDominio(it) }?.let { userRepository.save(it).paraDominio() }
    }

}