package net.weg.biblioteca.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import net.weg.biblioteca.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AutorRepository extends JpaRepository <Autor, Integer> {
}
