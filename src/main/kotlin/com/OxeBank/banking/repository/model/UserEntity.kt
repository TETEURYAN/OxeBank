package com.OxeBank.banking.repository.model

import com.OxeBank.banking.domain.User
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "fatura")
class UserEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    var nome: String,
    val valor: Long?
){

fun paraDominio(): User{
    return User(
        idcartao = id,
        name = nome,
        precofatura = valor!!,
    )
}
    companion object{
        fun doDominio(user: User): UserEntity{
            return UserEntity(
                id = user.idcartao,
                nome = user.name,
                valor = user.precofatura
            )
        }
    }
}
