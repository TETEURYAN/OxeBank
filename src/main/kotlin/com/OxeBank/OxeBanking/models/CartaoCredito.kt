package com.OxeBank.OxeBanking.models

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CartaoCredito {

    @GetMapping("/")
    fun getFatura(): String {
        return "Bem vindo ao OxeBanking"
    }
}