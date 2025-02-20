package net.weg.biblioteca.repository;
import net.weg.biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface LivroRepository extends JpaRepository <Livro, Integer> {

}
