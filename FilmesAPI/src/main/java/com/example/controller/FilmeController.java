package com.example.controller;

import com.example.model.Filme;
import com.example.repository.FilmeRepository;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository filmeRepository;
    
    @PostMapping
    public ResponseEntity<Filme> adicionarFilme(@RequestBody @Valid Filme filme) {
        Filme novoFilme = filmeRepository.save(filme);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoFilme);
    }

    @GetMapping
    public ResponseEntity<List<Filme>> listarFilmes() {
        List<Filme> filmes = filmeRepository.findAll();
        return ResponseEntity.ok(filmes);
    }

    @GetMapping("/ano/{anoLancamento}")
    public ResponseEntity<List<Filme>> listarPorAno(@PathVariable String anoLancamento) {
        List<Filme> filmes = filmeRepository.findByAnoLancamento(anoLancamento);
        return ResponseEntity.ok(filmes);
    }

    @GetMapping("/total")
    public ResponseEntity<Long> getTotalFilmes() {
        long total = filmeRepository.count();
        return ResponseEntity.ok(total);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Filme> listarFilmePorId(@PathVariable Long id) {
        return filmeRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFilme(@PathVariable Long id) {
        if (filmeRepository.existsById(id)) {
            filmeRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filme> atualizarFilme(@PathVariable Long id, @RequestBody @Valid Filme filmeAtualizado) {
        return filmeRepository.findById(id)
                .map(filme -> {
                    filme.setTitulo(filmeAtualizado.getTitulo());
                    filme.setGenero(filmeAtualizado.getGenero());
                    filme.setDuracao(filmeAtualizado.getDuracao());
                    filme.setDiretor(filmeAtualizado.getDiretor());
                    filme.setAnoLancamento(filmeAtualizado.getAnoLancamento());
                    filme.setPais(filmeAtualizado.getPais());
                    filme.setImdb(filmeAtualizado.getImdb());
                    Filme atualizado = filmeRepository.save(filme);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
