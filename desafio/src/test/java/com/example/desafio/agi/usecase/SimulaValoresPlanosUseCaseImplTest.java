package com.example.desafio.backend.usecase;

import com.example.desafio.backend.entity.Plano;
import com.example.desafio.backend.repository.PlanoRepository;
import com.example.desafio.backend.usecase.impl.SimulaValoresPlanosUseCaseImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class SimulaValoresPlanosUseCaseImplTest {

    @Mock
    private PlanoRepository planoRepository;

    @InjectMocks
    private SimulaValoresPlanosUseCaseImpl simulaValoresPlanosUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testExecuteWithValidData() throws Exception {
        // Dados simulados para planos
        List<Plano> planos = Arrays.asList(
                new Plano(1L, "Bronze", 100L, 10L),
                new Plano(2L, "Prata", 200L, 20L),
                new Plano(3L, "Ouro", 300L, 30L)
        );

        when(planoRepository.findAll()).thenReturn(planos);

        Long numeroDependentes = 3L;
        String expectedOutput =
                "----------------\n" +
                        "Plano: Bronze\n" +
                        "Taxa Contratação: R$ 100\n" +
                        "Valor plano: R$ 30\n" +
                        "Total: R$ 130\n" +
                        "----------------\n" +
                        "Plano: Prata\n" +
                        "Taxa Contratação: R$ 200\n" +
                        "Valor plano: R$ 60\n" +
                        "Total: R$ 260\n" +
                        "----------------\n" +
                        "Plano: Ouro\n" +
                        "Taxa Contratação: R$ 300\n" +
                        "Valor plano: R$ 90\n" +
                        "Total: R$ 390\n";

        String result = simulaValoresPlanosUseCase.execute(numeroDependentes);

        assertEquals(expectedOutput, result);
    }

    @Test
    void testExecuteWithNoPlans() {
        when(planoRepository.findAll()).thenReturn(Collections.emptyList());

        Long numeroDependentes = 3L;

        Exception exception = assertThrows(Exception.class, () -> {
            simulaValoresPlanosUseCase.execute(numeroDependentes);
        });

        assertEquals("Planos não encontrados", exception.getMessage());
    }
}
