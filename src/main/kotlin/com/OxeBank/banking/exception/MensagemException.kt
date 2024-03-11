package com.OxeBank.banking.exception

data class MensagemException(
    val status: Int,
    val mensagem: String?
)