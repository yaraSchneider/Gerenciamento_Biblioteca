package net.weg.biblioteca.dto;

import net.weg.biblioteca.model.Livro;
import net.weg.biblioteca.service.AutorService;
import net.weg.biblioteca.service.LivroService;
import net.weg.biblioteca.service.UsuarioService;

public record LivroRequestDTO(Integer idAutor, String titulo) {


    public Livro toEntity(AutorService autorService) {
        return Livro.builder()
                .titulo(titulo)
                .autor(autorService.buscarAutor(idAutor))
                .emprestado(false)
                .build();
    }
}
