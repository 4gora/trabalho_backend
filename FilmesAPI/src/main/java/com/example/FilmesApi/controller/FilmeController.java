package com.example.FilmesApi.controller;

import com.example.FilmesApi.model.Filme;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("filmes")
public class FilmeController {
    @PostMapping
    public void salvar(@RequestBody Filme filmes){
        System.out.println("FIlme recebido " + filmes);
    }
}
