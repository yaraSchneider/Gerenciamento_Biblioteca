package net.weg.biblioteca.dto;

import net.weg.biblioteca.model.Emprestimo;
import net.weg.biblioteca.service.LivroService;
import net.weg.biblioteca.service.UsuarioService;

public record EmprestimoRequestDTO(Integer livroId, Integer IdUsuario) {

    public Emprestimo toEntity(UsuarioService usuarioService, LivroService livroService) {
        return Emprestimo.builder()
                .livro(livroService.buscarLivro(livroId))
                .usuario(usuarioService.buscarUsuario(IdUsuario))
                .dataEmprestimo("")
                .dataDevolucao("")
                .build();
    }

}
