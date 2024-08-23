package com.example.desafio.backend.controller;

import com.example.desafio.backend.entity.Cliente;
import com.example.desafio.backend.usecase.AtualizaDadosClienteUseCase;
import com.example.desafio.backend.usecase.CadastraClienteUseCase;
import com.example.desafio.backend.usecase.ObtemDadosClienteUseCase;
import com.example.desafio.backend.usecase.RemoveClienteUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final CadastraClienteUseCase cadastraClienteUseCase;
    private final ObtemDadosClienteUseCase obtemDadosClienteUseCase;
    private final AtualizaDadosClienteUseCase atualizaDadosClienteUseCase;
    private final RemoveClienteUseCase removeClienteUseCase;

    @Autowired
    public ClienteController(CadastraClienteUseCase cadastraClienteUseCase,
                             ObtemDadosClienteUseCase obtemDadosClienteUseCase,
                             AtualizaDadosClienteUseCase atualizaDadosClienteUseCase,
                             RemoveClienteUseCase removeClienteUseCase) {
        this.cadastraClienteUseCase = cadastraClienteUseCase;
        this.obtemDadosClienteUseCase = obtemDadosClienteUseCase;
        this.atualizaDadosClienteUseCase = atualizaDadosClienteUseCase;
        this.removeClienteUseCase = removeClienteUseCase;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastroCliente(@RequestBody Cliente cliente) {
        try {
            cadastraClienteUseCase.execute(cliente);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
        return ResponseEntity.created(URI.create(cliente.getNome())).build();
    }

    @DeleteMapping("/remove/{cpf}")
    public ResponseEntity<String> removeCadastroPorCpf(@PathVariable(value = "cpf") Long cpf) {
        String mensagem;
        try {
            mensagem = removeClienteUseCase.execute(cpf);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
        return ResponseEntity.ok(mensagem);
    }

    @PostMapping("/atualiza")
    public ResponseEntity<String> atualizaDadosCliente(@RequestBody Cliente cliente) {
        String mensagem;
        try {
            mensagem = atualizaDadosClienteUseCase.execute(cliente);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
        return ResponseEntity.ok(mensagem);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Cliente> obtemDadosClientePorCpf(@PathVariable(value = "cpf") Long cpf) {
        Cliente cliente;
        try {
            cliente = obtemDadosClienteUseCase.execute(cpf);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok(cliente);
    }
}
