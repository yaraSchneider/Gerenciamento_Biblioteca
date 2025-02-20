package net.weg.biblioteca.dto;

import net.weg.biblioteca.model.Usuario;

public record UsuarioRequestDTO(String nome) {
    public Usuario toEntity() {
        return Usuario.builder()
                .nome(nome)
                .build();
    }
}
