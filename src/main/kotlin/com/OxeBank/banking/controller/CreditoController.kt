package com.OxeBank.banking.controller

import com.OxeBank.banking.controller.dto.CreditoDto
import com.OxeBank.banking.domain.Credito
import com.OxeBank.banking.service.CreditoService
import com.OxeBank.banking.domain.Fatura
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
@RequestMapping("/v1/produto")
class CreditoController(
        val listaFatura: HashMap<Long, Fatura> = HashMap<Long, Fatura>(),
    //private val creditoService: CreditoService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun salvar(@PathVariable idFatura: Long, @RequestBody creditoDto: CreditoDto): Credito? {
        //return creditoService.salvar(creditoDto)
        return listaFatura.get(idFatura)?.credito?.salvar(creditoDto)
    }

//    @GetMapping
//    fun buscarTodos(): List<Credito>{
//        //return creditoService.buscarTodos()
//    }

    @GetMapping("/{idFatura}/{pesquisa}")
    fun buscarComFiltro(@PathVariable idFatura: Long, @RequestBody  pesquisa: String): Credito? {
//        return creditoService.buscarComFiltro(pesquisa)
        return listaFatura.get(idFatura)?.credito?.buscarComFiltro(pesquisa)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable idFatura: Long, @RequestBody  alvo: Long): Unit? {
//        return creditoService.deletar(id)
        return listaFatura.get(idFatura)?.credito?.deletar(alvo)
    }

    @PutMapping("/{idFatura}/{id}")
    fun atualizar(@PathVariable idFatura: Long, @PathVariable  id: Long, @RequestBody creditoDto: CreditoDto): Credito?{
//        return creditoService.atualizar(id, creditoDto)
        return listaFatura.get(idFatura)?.credito?.atualizar(id,creditoDto)
    }
}