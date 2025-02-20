package net.weg.biblioteca.service;
import lombok.AllArgsConstructor;
import net.weg.biblioteca.dto.EmprestimoRequestDTO;
import net.weg.biblioteca.model.Emprestimo;
import net.weg.biblioteca.model.Emprestimo;
import net.weg.biblioteca.repository.EmprestimoRepository;
import net.weg.biblioteca.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmprestimoService {

    private EmprestimoRepository repository;
    private UsuarioService usuarioService;
    private LivroService livroService;

    public Emprestimo adicionarEmprestimo(EmprestimoRequestDTO dto) {
        Emprestimo emprestimo = dto.toEntity(usuarioService, livroService);
        return repository.save(emprestimo);
    }

    public Emprestimo buscarEmprestimo(Integer id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }
    public List<Emprestimo> buscarEmprestimoes() {
        return repository.findAll();
    }
    public void deletarEmprestimo(Integer id) {
        repository.deleteById(id);
    }

    public Emprestimo atualizarEmprestimo(EmprestimoRequestDTO dto, Integer id) {
        buscarEmprestimo(id); //Ver se existe o id passado

        Emprestimo emprestimoNovo = dto.toEntity(usuarioService, livroService);

        emprestimoNovo.setId(id);
        return repository.save(emprestimoNovo);
    }
}
