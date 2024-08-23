package com.example.desafio.backend.usecase.impl;

import com.example.desafio.backend.entity.Cliente;
import com.example.desafio.backend.repository.ClienteRepository;
import com.example.desafio.backend.usecase.CadastraClienteUseCase;

import java.util.Objects;

public class CadastraClienteUseCaseImpl implements CadastraClienteUseCase {

    private final String SUCESSO = "Cliente cadastrado com sucesso";
    private final String ERRO = "Cliente não cadastrado";

    ClienteRepository clienteRepository;

    public CadastraClienteUseCaseImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public String execute(Cliente cliente) throws Exception {

        if(Objects.isNull(cliente.getCpf())){
            throw new Exception(ERRO);
        }
        clienteRepository.save(cliente);

        return SUCESSO;
    }


}
