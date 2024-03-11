package com.OxeBank.banking.controller

import com.OxeBank.banking.controller.dto.CreditoDto
import com.OxeBank.banking.domain.Credito
import com.OxeBank.banking.service.CreditoService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/usuario")
class CreditoController(
    private val creditoService: CreditoService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun salvar(@Valid @RequestBody creditoDto: CreditoDto): Credito {
        return creditoService.salvar(creditoDto)
    }

    @GetMapping
    fun buscarTodos(): List<Credito>{
        return creditoService.buscarTodos()
    }

    @GetMapping("/{pesquisa}")
    fun buscarComFiltro(@PathVariable pesquisa: String): Credito {
        return creditoService.buscarComFiltro(pesquisa)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long){
        return creditoService.deletar(id)
    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @RequestBody creditoDto: CreditoDto): Credito?{
        return creditoService.atualizar(id, creditoDto)
    }
}