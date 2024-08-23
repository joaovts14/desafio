package com.example.desafio.backend.usecase;

import com.example.desafio.backend.entity.Cliente;

public interface ObtemDadosClienteUseCase {
    Cliente execute(Long cpf) throws Exception;
}
