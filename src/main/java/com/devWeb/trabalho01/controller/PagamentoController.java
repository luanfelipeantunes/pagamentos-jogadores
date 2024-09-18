package com.devWeb.trabalho01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.devWeb.trabalho01.model.Pagamento;
import com.devWeb.trabalho01.repository.PagamentoRepository;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {
    
    @Autowired
    private PagamentoRepository pagamentoRepository;

    //Lista Pagamentos
    @GetMapping
    public List<Pagamento> listarPagamentos(){
        return pagamentoRepository.findAll();
    }

    //Retorna um pagamento pelo código
    @GetMapping("/{codPagamento}")
    public Pagamento buscaPagamento(@RequestParam Integer codPagamento){
        Pagamento pagamento = pagamentoRepository.findById(codPagamento).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return pagamento;
    }

    //Cadastra um pagamento
    @PostMapping
    public ResponseEntity<Pagamento> cadastrarPagamento(@RequestBody Pagamento pagamento){
        pagamentoRepository.save(pagamento);
        return new ResponseEntity<>(pagamento, HttpStatus.CREATED);
    }
}
