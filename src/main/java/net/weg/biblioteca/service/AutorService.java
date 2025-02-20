package net.weg.biblioteca.service;

import lombok.AllArgsConstructor;
import net.weg.biblioteca.model.Autor;
import net.weg.biblioteca.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class AutorService {

    private AutorRepository repository;

    public Autor adicionarAutor(Autor autor) {
        return repository.save(autor);
    }

    public Autor buscarAutor(Integer id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }
    public List<Autor> buscarAutores() {
        return repository.findAll();
    }
    public void deletarAutor(Integer id) {
        repository.deleteById(id);
    }

    public Autor atualizarAutor(Autor autor, Integer id) {
        buscarAutor(id);

        autor.setId(id);
        return repository.save(autor);
    }


}
