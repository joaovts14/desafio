package com.example.desafio.backend.usecase.impl;

import com.example.desafio.backend.entity.Plano;
import com.example.desafio.backend.repository.PlanoRepository;
import com.example.desafio.backend.usecase.SimulaValoresPlanosUseCase;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class SimulaValoresPlanosUseCaseImpl implements SimulaValoresPlanosUseCase {

    private final String ERRO = "Planos não encontrados";

    PlanoRepository planoRepository;

    public SimulaValoresPlanosUseCaseImpl(PlanoRepository planoRepository) {
        this.planoRepository = planoRepository;
    }

    @Override
    public String execute(Long numeroDependentes) throws Exception {

        List<Plano> planos = planoRepository.findAll();

        AtomicReference<String> relatorioFinal = new AtomicReference<>("");
        if(planos.isEmpty()){
            throw new Exception(ERRO);
        }

        planos.forEach(plano -> {
            Long valorPlano = plano.getTaxaPorDependentes()*numeroDependentes;
            Long total = plano.getTaxaContratacao() + valorPlano;
            relatorioFinal.set(relatorioFinal.get()
                    .concat("----------------").concat("\n")
                    .concat("Plano: ").concat(plano.getNome()).concat("\n")
                    .concat("Taxa Contratação: R$ ").concat(plano.getTaxaContratacao().toString()).concat("\n")
                    .concat("Valor plano: R$ ").concat(valorPlano.toString()).concat("\n")
                    .concat("Total: R$ ").concat(total.toString()).concat("\n"));
        });

        return relatorioFinal.get();
    }
}
