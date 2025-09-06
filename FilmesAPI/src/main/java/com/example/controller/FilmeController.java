package com.example.controller;

import com.example.model.Filme;
import com.example.repository.FilmeRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository filmeRepository;
    
    @PostMapping
    public Filme adicionarFilme(@RequestBody Filme filme) {
        return filmeRepository.save(filme);
    }

    @GetMapping
    public List<Filme> listarFilmes() {
        return filmeRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Filme listarFilmePorId(@PathVariable Long id) {
        return filmeRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletarFilme(@PathVariable Long id) {
        filmeRepository.deleteById(id);
    }
}
