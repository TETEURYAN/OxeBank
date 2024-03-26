package com.OxeBank.banking.controller

import com.OxeBank.banking.controller.dto.CreditoDto
import com.OxeBank.banking.controller.dto.FaturaDto
import com.OxeBank.banking.dao.UserService
import com.OxeBank.banking.domain.Credito
import com.OxeBank.banking.domain.User
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
@RequestMapping("/sistema")
class GeneralController(
    private val creditoService: CreditoService,
    private val userService: UserService
) {

    @PostMapping("/adiciona")
    @ResponseStatus(HttpStatus.CREATED)
    fun salvar(@RequestBody creditoDto: CreditoDto): Credito? {
        var credito = creditoDto
        userService.atualizarUser(credito)
        return creditoService.salvar(credito)
    }

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    fun salvarUser(@RequestBody faturaDto: FaturaDto): User? {
        return userService.salvar(faturaDto)
    }

    @GetMapping("/produtos")
    fun buscarTodos(): List<Credito>{
        return creditoService.buscarTodos()
    }

    @GetMapping("/user")
    fun buscarTodosUser(): List<User>{
        return userService.buscarTodos()
    }

    @GetMapping("/compras/{idUser}")
    fun buscarComprasUser(@PathVariable idUser: Long): List<Credito>? {
        return creditoService.buscarComprasUser(idUser)
    }

    @GetMapping("/produtos/{pesquisa}")
    fun buscarComFiltro(@PathVariable pesquisa: String): Credito? {
        return creditoService.buscarComFiltro(pesquisa)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long): Unit? {
        var compra: Credito = creditoService.buscarComFiltro(id.toString())
        userService.remover(compra)
        return creditoService.deletar(id)
    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable  id:Long, @RequestBody creditoDto: CreditoDto): Credito?{
        var compra: Credito = creditoService.buscarComFiltro(id.toString())
        userService.remover(compra)
        userService.atualizarUser(creditoDto)
       return creditoService.atualizar(id, creditoDto)
    }
}