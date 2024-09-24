package com.devWeb.trabalho01.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "jogador")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer codJogador;

    @Column
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @Column
    @NotBlank(message = "Email é obrigatório")
    private String email;

    @Column
    @NotBlank(message = "Data de nascimento é obrigatória")
    private LocalDate dataNasc;

    public Integer getCodJogador() {
        return codJogador;
    }

    public void setCodJogador(Integer codJogador) {
        this.codJogador = codJogador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }
}
