package com.devWeb.trabalho01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.devWeb.trabalho01.model.Jogador;
import com.devWeb.trabalho01.repository.JogadorRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/jogador")
public class JogadorController {

    @Autowired
    private JogadorRepository jogadorRepository;

    // Lista Jogadores
    @GetMapping
    public List<Jogador> listarJogadores() {
        return jogadorRepository.findAll();
    }

    // Retorna um jogador pelo código único
    @GetMapping("/{codJogador}")
    public Jogador buscaJogador(@PathVariable Integer codJogador) {
        Jogador jogador = jogadorRepository.findById(codJogador)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return jogador;
    }

    // Cadastra um jogador
    @PostMapping
    public ResponseEntity<Jogador> cadastrarJogador(@RequestBody Jogador jogador) {
        try {
            jogadorRepository.save(jogador);
            return new ResponseEntity<>(jogador, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao cadastrar jogador");
        }
    }

    // Update de um jogador
    @PutMapping("/{codJogador}")
    public Jogador atualizaJogador(@PathVariable Integer codJogador, @Valid @RequestBody Jogador jogador) {
        try {
            Jogador jogadorAtual = jogadorRepository.findById(codJogador)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            jogadorAtual.setNome(jogador.getNome());
            jogadorAtual.setEmail(jogador.getEmail());
            jogadorAtual.setDataNasc(jogador.getDataNasc());
            return jogadorRepository.save(jogadorAtual);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao atualizar jogador");
        }
    }

    // Deleta um jogador
    @DeleteMapping("/{codJogador}")
    public ResponseEntity<Void> deletaJogador(@PathVariable Integer codJogador) {
        Jogador jogadorAtual = jogadorRepository.findById(codJogador)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        jogadorRepository.delete(jogadorAtual);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
