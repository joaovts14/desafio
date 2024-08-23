package com.example.desafio.backend.usecase.impl;

import com.example.desafio.backend.entity.Cliente;
import com.example.desafio.backend.repository.ClienteRepository;
import com.example.desafio.backend.usecase.RemoveClienteUseCase;

import java.util.Objects;
import java.util.Optional;

public class RemoveClienteUseCaseImpl implements RemoveClienteUseCase {

    private final String SUCESSO = "Cliente removido com sucesso";
    private final String NAO_ENCONTRADO = "Cliente não encontrado";
    private final String ERRO = "Cpf não pode ser nulo";

    ClienteRepository clienteRepository;

    public RemoveClienteUseCaseImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public String execute(Long cpf) throws Exception {

        if(Objects.isNull(cpf)){
            throw new Exception(ERRO);
        }

        Optional<Cliente> clienteDelete = clienteRepository.findById(cpf);

        if(clienteDelete.isEmpty()){
            throw new Exception(NAO_ENCONTRADO);
        }

        clienteRepository.delete(clienteDelete.get());

        return SUCESSO;
    }


}
