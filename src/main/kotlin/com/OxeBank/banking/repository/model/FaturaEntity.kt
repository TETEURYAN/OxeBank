package com.OxeBank.banking.repository.model

import com.OxeBank.banking.domain.Credito
import com.OxeBank.banking.service.CreditoService
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "fatura")
class FaturaEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idCartao: Long?,
)