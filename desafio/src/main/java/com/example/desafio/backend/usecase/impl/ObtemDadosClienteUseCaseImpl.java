package com.example.desafio.backend.usecase.impl;

import com.example.desafio.backend.entity.Cliente;
import com.example.desafio.backend.repository.ClienteRepository;
import com.example.desafio.backend.usecase.ObtemDadosClienteUseCase;

import java.util.Objects;
import java.util.Optional;

public class ObtemDadosClienteUseCaseImpl implements ObtemDadosClienteUseCase {

    private final String NAO_ENCONTRADO = "Cliente não encontrado";
    private final String ERRO = "Cpf não pode ser nulo";

    ClienteRepository clienteRepository;

    public ObtemDadosClienteUseCaseImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente execute(Long cpf) throws Exception {

        if(Objects.isNull(cpf)){
            throw new Exception(ERRO);
        }

        Optional<Cliente> cliente = clienteRepository.findById(cpf);

        if(cliente.isEmpty()){
            throw new Exception(NAO_ENCONTRADO);
        }

        return cliente.get();
    }


}
