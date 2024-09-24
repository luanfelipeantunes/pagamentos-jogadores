package com.devWeb.trabalho01.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pagamento")
public class Pagamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codPagamento;

    @Column
    private Integer ano;

    @Column
    private Integer mes;

    @Column
    private Double valor;

    @ManyToOne
    @JoinColumn(name = "codJogador", nullable = false)
    private Jogador codJogador;

    public Integer getCodPagamento() {
        return codPagamento;
    }

    public void setCodPagamento(Integer codPagamento) {
        this.codPagamento = codPagamento;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Jogador getCodJogador() {
        return codJogador;
    }

    public void setCodJogador(Jogador codJogador) {
        this.codJogador = codJogador;
    }

    

}
