package com.example.desafio.backend.usecase;

public interface ContrataPlanoUseCase {
    String execute(Long idPlano, Long cpfCliente) throws Exception;
}
