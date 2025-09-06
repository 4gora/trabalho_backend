package com.example.repository;

import com.example.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {
    // Métodos customizados podem ser adicionados aqui
    List<Filme> findByAnoLancamento(String anoLancamento);
}
