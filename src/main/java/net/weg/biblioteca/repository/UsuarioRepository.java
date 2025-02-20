package net.weg.biblioteca.repository;

import net.weg.biblioteca.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UsuarioRepository extends JpaRepository <Usuario, Integer> {
}
