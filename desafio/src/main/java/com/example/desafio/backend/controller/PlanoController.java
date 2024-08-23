package com.example.desafio.backend.controller;

import com.example.desafio.backend.usecase.*;
import com.example.desafio.backend.usecase.ContrataPlanoUseCase;
import com.example.desafio.backend.usecase.SimulaValoresPlanosUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plano")
public class PlanoController {


    private final SimulaValoresPlanosUseCase simulaValoresPlanosUseCase;
    private final ContrataPlanoUseCase contrataPlanoUseCase;

    public PlanoController(SimulaValoresPlanosUseCase simulaValoresPlanosUseCase,
                           ContrataPlanoUseCase contrataPlanoUseCase) {
        this.simulaValoresPlanosUseCase = simulaValoresPlanosUseCase;
        this.contrataPlanoUseCase = contrataPlanoUseCase;
    }

    @GetMapping("/simular/{dependentes}")
    public ResponseEntity<String> simular(@PathVariable(value="dependentes") Long dependentes){
        String mensagem = null;
        try {
            mensagem = simulaValoresPlanosUseCase.execute(dependentes);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
        return ResponseEntity.ok(mensagem);
    }

    @GetMapping("/contratar/{cpf}/{plano}")
    public ResponseEntity<String> simular(@PathVariable(value="cpf") Long cpf,
                                          @PathVariable(value="plano") Long plano){
        String mensagem = null;
        try {
            mensagem = contrataPlanoUseCase.execute(plano, cpf);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
        return ResponseEntity.ok(mensagem);
    }


}
