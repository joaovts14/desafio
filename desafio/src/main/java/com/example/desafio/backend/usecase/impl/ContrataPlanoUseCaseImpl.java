package com.example.desafio.backend.usecase.impl;

import com.example.desafio.backend.entity.Cliente;
import com.example.desafio.backend.entity.Plano;
import com.example.desafio.backend.repository.ClienteRepository;
import com.example.desafio.backend.repository.PlanoRepository;
import com.example.desafio.backend.service.ClienteService;
import com.example.desafio.backend.usecase.ContrataPlanoUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ContrataPlanoUseCaseImpl implements ContrataPlanoUseCase {

    private final String ERRO = "Erro ao contratar plano";
    private final String SUCESSO = "Plano contratado";

    PlanoRepository planoRepository;
    ClienteRepository clienteRepository;
    ClienteService clienteService;

    public ContrataPlanoUseCaseImpl(PlanoRepository planoRepository, ClienteService clienteService,
                                    ClienteRepository clienteRepository) {
        this.planoRepository = planoRepository;
        this.clienteService = clienteService;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public String execute(Long idPlano, Long cpfCliente) throws Exception {

        ResponseEntity responseEntity = clienteService.verificaDadosCliente(cpfCliente.toString());

        if(responseEntity.getStatusCode().equals(HttpStatus.OK)){
            Cliente cliente = (Cliente) responseEntity.getBody();
            Plano plano = planoRepository.findById(idPlano).get();

            cliente.setPlano(plano);
            clienteRepository.save(cliente);

        }else{
            return ERRO;
        }

        return SUCESSO;
    }
}
