package net.weg.biblioteca.model;
import jakarta.persistence.*;
import lombok.*;

    @Builder
    @Entity
    @Table(name = "livros")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Livro {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        private String titulo;

        @ManyToOne
        @JoinColumn(name = "autor_id", nullable = false)
        private Autor autor;

        private boolean emprestado;
    }
