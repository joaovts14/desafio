package com.example.desafio.backend.controller;

import com.example.desafio.backend.controller.PlanoController;
import com.example.desafio.backend.usecase.ContrataPlanoUseCase;
import com.example.desafio.backend.usecase.SimulaValoresPlanosUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class PlanoControllerTest {

    @Mock
    private SimulaValoresPlanosUseCase simulaValoresPlanosUseCase;

    @Mock
    private ContrataPlanoUseCase contrataPlanoUseCase;

    @InjectMocks
    private PlanoController planoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSimular() throws Exception {
        Long dependentes = 3L;
        String expectedMessage = "Simulação de valores para 3 dependentes";

        when(simulaValoresPlanosUseCase.execute(dependentes)).thenReturn(expectedMessage);

        ResponseEntity<String> response = planoController.simular(dependentes);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedMessage, response.getBody());
    }

    @Test
    void testSimular_Exception() throws Exception {
        Long dependentes = 3L;
        String errorMessage = "Erro na simulação";

        when(simulaValoresPlanosUseCase.execute(dependentes)).thenThrow(new RuntimeException(errorMessage));

        ResponseEntity<String> response = planoController.simular(dependentes);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals(errorMessage, response.getBody());
    }

    @Test
    void testContratar() throws Exception {
        Long cpf = 12345678900L;
        Long plano = 1L;
        String expectedMessage = "Plano contratado com sucesso";

        when(contrataPlanoUseCase.execute(plano, cpf)).thenReturn(expectedMessage);

        ResponseEntity<String> response = planoController.simular(cpf, plano);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedMessage, response.getBody());
    }

    @Test
    void testContratar_Exception() throws Exception {
        Long cpf = 12345678900L;
        Long plano = 1L;
        String errorMessage = "Erro ao contratar plano";

        when(contrataPlanoUseCase.execute(plano, cpf)).thenThrow(new RuntimeException(errorMessage));

        ResponseEntity<String> response = planoController.simular(cpf, plano);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals(errorMessage, response.getBody());
    }
}
