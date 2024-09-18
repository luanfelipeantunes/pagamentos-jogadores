package com.devWeb.trabalho01.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "jogador")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer codJogador;

    @Column
    private String nome;

    @Column
    private String email;

    @Column
    private Date dataNasc;

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

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }
}
