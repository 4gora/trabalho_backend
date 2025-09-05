package com.example.ProdutosAPI.controller;

import com.example.ProdutosAPI.model.Produto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("produtos")
public class ProdutoController {
    @PostMapping
    public void salvar(@RequestBody Produto produtos){
        System.out.println("Produto recebido" + produtos);
    }
}
