package com.example.desafio.backend.service;

import com.example.desafio.backend.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClienteService {

    private final RestTemplate restTemplate;

    @Autowired
    public ClienteService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity verificaDadosCliente(String cpf) {
        String url = "http://localhost:8080/cliente/" + cpf;
        Cliente retorno = null;
        try {
            retorno = restTemplate.getForObject(url, Cliente.class);
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(retorno);

    }
}

