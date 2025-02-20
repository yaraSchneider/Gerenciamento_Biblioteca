package net.weg.biblioteca.repository;

import net.weg.biblioteca.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer> {
}
