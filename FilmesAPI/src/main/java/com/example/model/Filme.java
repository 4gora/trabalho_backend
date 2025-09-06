package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

@Entity
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo título é obrigatório.")
    private String titulo;

    private String genero;
    private int duracao;
    private String diretor;
    private String anoLancamento;
    private String pais;

    @Min(value = 0, message = "A nota IMDb mínima é 0.")
    @Max(value = 10, message = "A nota IMDb máxima é 10.")
    private double imdb;

    public Filme() {
        
    }

    public Filme(Long id, String titulo, String genero, int duracao, String diretor, String anoLancamento, String pais, double imdb) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.duracao = duracao;
        this.diretor = diretor;
        this.anoLancamento = anoLancamento;
        this.pais = pais;
        this.imdb = imdb;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public double getImdb() {
        return imdb;
    }

    public void setImdb(double imdb) {
        this.imdb = imdb;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", duracao=" + duracao +
                ", diretor='" + diretor + '\'' +
                ", anoLancamento='" + anoLancamento + '\'' +
                ", pais='" + pais + '\'' +
                ", imdb=" + imdb +
                '}';
    }
}
