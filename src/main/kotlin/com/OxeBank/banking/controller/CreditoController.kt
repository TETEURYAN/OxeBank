package com.OxeBank.banking.controller

import com.OxeBank.banking.controller.dto.CreditoDto
import com.OxeBank.banking.controller.dto.FaturaDto
import com.OxeBank.banking.dao.FaturaService
import com.OxeBank.banking.domain.Credito
import com.OxeBank.banking.domain.Fatura
import com.OxeBank.banking.service.CreditoService
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
    private val creditoService: CreditoService,
    private val faturaService: FaturaService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun salvar(@RequestBody creditoDto: CreditoDto): Credito? {
        var credito = creditoDto

        return creditoService.salvar(credito)
        //return listaFatura.get(idFatura)?.credito?.salvar(creditoDto)
    }

    @PostMapping("/fatura")
    @ResponseStatus(HttpStatus.CREATED)
    fun salvarUser(@RequestBody faturaDto: FaturaDto): Fatura? {
        return faturaService.salvar(faturaDto)
        //return listaFatura.get(idFatura)?.credito?.salvar(creditoDto)
    }

    @GetMapping
    fun buscarTodos(): List<Credito>{
        return creditoService.buscarTodos()
    }

    @GetMapping("/fatura")
    fun buscarTodosFatura(): List<Fatura>{
        return faturaService.buscarTodos()
    }

    @GetMapping("/{idFatura}/{pesquisa}")
    fun buscarComFiltro(@PathVariable idFatura: Long, @RequestBody  pesquisa: String): Credito? {
        return creditoService.buscarComFiltro(pesquisa)
        //return listaFatura.get(idFatura)?.credito?.buscarComFiltro(pesquisa)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long): Unit? {
        return creditoService.deletar(id)
        //return listaFatura.get(idFatura)?.credito?.deletar(alvo)
    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable  id: Long, @RequestBody creditoDto: CreditoDto): Credito?{
       return creditoService.atualizar(id, creditoDto)
        //return listaFatura.get(idFatura)?.credito?.atualizar(id,creditoDto)
    }
}