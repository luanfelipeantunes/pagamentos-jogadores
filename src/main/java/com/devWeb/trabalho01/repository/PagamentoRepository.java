package com.devWeb.trabalho01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.devWeb.trabalho01.model.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{ 
}
