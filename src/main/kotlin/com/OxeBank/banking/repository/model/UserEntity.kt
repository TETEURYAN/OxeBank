package com.OxeBank.banking.repository.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "usuario")
class UserEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var nome: String,
    var id: Long?
)