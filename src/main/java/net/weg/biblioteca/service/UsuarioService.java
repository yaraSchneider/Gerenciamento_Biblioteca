package net.weg.biblioteca.service;
import lombok.AllArgsConstructor;
import net.weg.biblioteca.dto.UsuarioRequestDTO;
import net.weg.biblioteca.model.Usuario;
import net.weg.biblioteca.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Classe de serviço responsável pelo gerenciamento de operações relacionadas a usuários.
 */
@Service
@AllArgsConstructor
public class UsuarioService {

    private UsuarioRepository repository;

    /**
     * Adiciona um novo usuário ao repositório.
     *
     * @param usuarioRequestDTO Objeto DTO contendo as informações do usuário a ser adicionado.
     * @return O usuário salvo no repositório.
     */
    public Usuario adicionarUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        return repository.save(usuarioRequestDTO.toEntity());
    }

    /**
     * Busca um usuário no repositório com base no ID informado.
     *
     * @param id Identificador do usuário a ser buscado.
     * @return O usuário encontrado.
     * @throws NoSuchElementException Se o usuário não for encontrado.
     */
    public Usuario buscarUsuario(Integer id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    /**
     * Busca todos os usuários cadastrados no repositório.
     *
     * @return Lista de usuários cadastrados.
     */
    public List<Usuario> buscarUsuarioes() {
        return repository.findAll();
    }

    /**
     * Deleta um usuário do repositório com base no ID informado.
     *
     * @param id Identificador do usuário a ser removido.
     */
    public void deletarUsuario(Integer id) {
        repository.deleteById(id);
    }

    /**
     * Atualiza um usuário existente no repositório.
     *
     * @param usuarioRequestDTO Objeto DTO contendo as novas informações do usuário.
     * @param id Identificador do usuário a ser atualizado.
     * @return O usuário atualizado e salvo no repositório.
     */
    public Usuario atualizarUsuario(UsuarioRequestDTO usuarioRequestDTO, Integer id) {
        buscarUsuario(id);
        Usuario usuario = usuarioRequestDTO.toEntity();
        usuario.setId(id);
        return repository.save(usuario);
    }
}
