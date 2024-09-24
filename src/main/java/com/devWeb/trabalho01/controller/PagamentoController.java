package com.devWeb.trabalho01.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.devWeb.trabalho01.model.Jogador;
import com.devWeb.trabalho01.model.Pagamento;
import com.devWeb.trabalho01.repository.JogadorRepository;
import com.devWeb.trabalho01.repository.PagamentoRepository;
@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private JogadorRepository jogadorRepository;

    // Lista Pagamentos
    @GetMapping
    public List<Pagamento> listarPagamentos() {
        return pagamentoRepository.findAll();
    }

    // Retorna um pagamento pelo código
    @GetMapping("/{codPagamento}")
    public Pagamento buscaPagamento(@PathVariable Integer codPagamento) {
        Pagamento pagamento = pagamentoRepository.findById(codPagamento)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return pagamento;
    }

    // Cadastra um pagamento
    @PostMapping
    public ResponseEntity<Pagamento> cadastrarPagamento(@RequestBody Map<String, Object> body){
        try {
            Integer codJogadorId = Integer.valueOf(body.get("codJogador").toString());
            Optional<Jogador> jogador = jogadorRepository.findById(codJogadorId);

            if (!jogador.isPresent()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogador não encontrado");
            }

            Pagamento pagamento = new Pagamento();
            pagamento.setAno((Integer)body.get("ano"));
            pagamento.setMes((Integer)body.get("mes"));
            pagamento.setValor((Double)body.get("valor"));

            //Seta o jogador
            pagamento.setCodJogador(jogador.get());

            //Seta o pagamento
            pagamentoRepository.save(pagamento);
            return new ResponseEntity<Pagamento>(pagamento, HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println(e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Atualiza um pagamento
    @PutMapping("/{codPagamento}")
    public ResponseEntity<Pagamento> atualizarPagamento(@PathVariable Integer codPagamento, @RequestBody Map<String, Object> body) {
        try {
            Pagamento pagamento = pagamentoRepository.findById(codPagamento)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

            Integer codJogadorId = Integer.valueOf(body.get("codJogador").toString());
            Optional<Jogador> jogador = jogadorRepository.findById(codJogadorId);

            if (!jogador.isPresent()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogador não encontrado");
            }

            pagamento.setAno((Integer)body.get("ano"));
            pagamento.setMes((Integer)body.get("mes"));
            pagamento.setValor((Double)body.get("valor"));

            //Seta o jogador
            pagamento.setCodJogador(jogador.get());

            //Seta o pagamento
            pagamentoRepository.save(pagamento);
            return new ResponseEntity<Pagamento>(pagamento, HttpStatus.OK);
        } catch (Exception e) {
            System.err.println(e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
