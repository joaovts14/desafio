package com.example.desafio.backend.usecase;

import com.example.desafio.backend.entity.Cliente;

public interface CadastraClienteUseCase {
    String execute(Cliente cliente) throws Exception;
}
