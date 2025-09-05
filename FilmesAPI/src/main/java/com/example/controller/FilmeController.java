package com.example.controller;

import com.example.model.Filme;
import com.example.repository.FilmeRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository filmeRepository;
    
    @PostMapping
    public Filme adicionarFilme(@RequestBody Filme filme) {
        return filmeRepository.save(filme);
    }

    public List<Filme> listarFilmes() {
        return filmeRepository.findAll();
    }
}
