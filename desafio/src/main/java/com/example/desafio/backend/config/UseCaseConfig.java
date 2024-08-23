package com.example.desafio.backend.config;

import com.example.desafio.backend.repository.ClienteRepository;
import com.example.desafio.backend.repository.PlanoRepository;
import com.example.desafio.backend.service.ClienteService;
import com.example.desafio.backend.usecase.*;
import com.example.desafio.backend.usecase.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public CadastraClienteUseCase cadastraClienteUseCase(ClienteRepository clienteRepository) {
        return new CadastraClienteUseCaseImpl(clienteRepository);
    }

    @Bean
    public ObtemDadosClienteUseCase obtemDadosClienteUseCase(ClienteRepository clienteRepository) {
        return new ObtemDadosClienteUseCaseImpl(clienteRepository);
    }

    @Bean
    public AtualizaDadosClienteUseCase atualizaDadosClienteUseCase(ClienteRepository clienteRepository) {
        return new AtualizaDadosClienteUseCaseImpl(clienteRepository);
    }

    @Bean
    public RemoveClienteUseCase removeClienteUseCase(ClienteRepository clienteRepository) {
        return new RemoveClienteUseCaseImpl(clienteRepository);
    }

    @Bean
    public SimulaValoresPlanosUseCase simulaValoresPlanosUseCase(PlanoRepository planoRepository){
        return new SimulaValoresPlanosUseCaseImpl(planoRepository);
    }

    @Bean
    public ContrataPlanoUseCase contrataPlanoUseCase(PlanoRepository planoRepository,
                                                     ClienteService clienteService,
                                                     ClienteRepository clienteRepository){
        return new ContrataPlanoUseCaseImpl(planoRepository, clienteService, clienteRepository);
    }
}
