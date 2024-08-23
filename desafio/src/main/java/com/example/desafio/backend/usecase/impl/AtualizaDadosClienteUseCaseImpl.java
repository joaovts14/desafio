package com.example.desafio.backend.usecase.impl;

import com.example.desafio.backend.entity.Cliente;
import com.example.desafio.backend.repository.ClienteRepository;
import com.example.desafio.backend.usecase.AtualizaDadosClienteUseCase;

import java.util.Objects;
import java.util.Optional;

public class AtualizaDadosClienteUseCaseImpl implements AtualizaDadosClienteUseCase {

    private final String SUCESSO = "Cliente atualizado com sucesso";
    private final String NAO_ENCONTRADO = "Cliente não encontrado";
    private final String ERRO = "Cpf não pode ser nulo";

    ClienteRepository clienteRepository;

    public AtualizaDadosClienteUseCaseImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public String execute(Cliente cliente) throws Exception {
        if(Objects.isNull(cliente.getCpf())){
            throw new Exception(ERRO);
        }

        Optional<Cliente> clienteUpdate = clienteRepository.findById(cliente.getCpf());

        if(clienteUpdate.isEmpty()){
            throw new Exception(NAO_ENCONTRADO);
        }

        Cliente clienteFinal = clienteUpdate.get();

        if(Objects.nonNull(cliente.getDataNascimento())){
            clienteFinal.setDataNascimento(cliente.getDataNascimento());
        }

        if (Objects.nonNull(cliente.getNome())) {
            clienteFinal.setNome(cliente.getNome());
        }

        if (Objects.nonNull(cliente.getDataNascimento())) {
            clienteFinal.setDataNascimento(cliente.getDataNascimento());
        }

        if (Objects.nonNull(cliente.getTelefone())) {
            clienteFinal.setTelefone(cliente.getTelefone());
        }

        if (Objects.nonNull(cliente.getEnderecoCompleto())) {
            clienteFinal.setEnderecoCompleto(cliente.getEnderecoCompleto());
        }

        clienteRepository.save(clienteFinal);

        return SUCESSO;
    }
}
