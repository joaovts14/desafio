package com.example.desafio.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "planos")
public class Plano {

    @Id
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(name = "taxa_contratacao", nullable = false)
    private Long taxaContratacao;

    @Column(name = "taxa_dependentes",nullable = false)
    private Long taxaPorDependentes;

}

