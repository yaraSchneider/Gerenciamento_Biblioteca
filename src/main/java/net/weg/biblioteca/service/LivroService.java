package net.weg.biblioteca.service;
import lombok.AllArgsConstructor;
import net.weg.biblioteca.dto.LivroRequestDTO;
import net.weg.biblioteca.model.Livro;
import net.weg.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Classe de serviço responsável pelo gerenciamento de operações relacionadas a livros.
 */
@Service
@AllArgsConstructor
public class LivroService {

    private LivroRepository repository;
    private AutorService autorService;

    /**
     * Adiciona um novo livro ao repositório.
     *
     * @param dto Objeto DTO contendo as informações do livro a ser adicionado.
     * @return O livro salvo no repositório.
     */
    public Livro adicionarLivro(LivroRequestDTO dto) {
        Livro livro = dto.toEntity(autorService);
        return repository.save(livro);
    }

    /**
     * Busca todos os livros cadastrados no repositório.
     *
     * @return Lista de livros cadastrados.
     */
    public List<Livro> buscarLivroes() {
        return repository.findAll();
    }

    /**
     * Deleta um livro do repositório com base no ID informado.
     *
     * @param id Identificador do livro a ser removido.
     */
    public void deletarLivro(Integer id) {
        repository.deleteById(id);
    }

    /**
     * Atualiza um livro existente no repositório.
     *
     * @param dto Objeto DTO contendo as novas informações do livro.
     * @param id Identificador do livro a ser atualizado.
     * @return O livro atualizado e salvo no repositório.
     */
    public Livro atualizarLivro(LivroRequestDTO dto, Integer id) {
        buscarLivro(id); // Verifica se o livro existe
        Livro livroNovo = dto.toEntity(autorService);
        livroNovo.setId(id);
        return repository.save(livroNovo);
    }

    /**
     * Busca um livro no repositório com base no ID informado.
     *
     * @param id Identificador do livro a ser buscado.
     * @return O livro encontrado.
     * @throws NoSuchElementException Se o livro não for encontrado.
     */
    public Livro buscarLivro(Integer id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
