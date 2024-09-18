package com.devWeb.trabalho01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.devWeb.trabalho01.model.Jogador;

public interface JogadorRepository extends JpaRepository<Jogador, Integer> {
}
