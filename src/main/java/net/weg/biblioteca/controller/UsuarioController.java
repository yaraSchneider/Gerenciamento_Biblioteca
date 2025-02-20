package net.weg.biblioteca.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import net.weg.biblioteca.dto.UsuarioRequestDTO;
import net.weg.biblioteca.model.Livro;
import net.weg.biblioteca.model.Usuario;
import net.weg.biblioteca.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@AllArgsConstructor
public class UsuarioController {

    private UsuarioService service;

    @PostMapping("/post")
    @Operation(summary = "Adicionar Usuario:", description = "Postar usuario no banco de dados")
    @ApiResponse(responseCode = "201", description = "Livro criado com sucesso", content = @Content(schema = @Schema(implementation = Livro.class)))
    @ApiResponse(responseCode = "400", description = "Requisição inválida")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public ResponseEntity<Usuario> postUsuario(@RequestBody UsuarioRequestDTO usuario) {
        try {
            return new ResponseEntity<>(service.adicionarUsuario(usuario), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Usuario> putUsuario(@RequestBody UsuarioRequestDTO usuario, @PathVariable Integer id) {
        try {
            return new ResponseEntity<>(service.atualizarUsuario(usuario, id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        try {
            service.deletarUsuario(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getId/{id}")
    public ResponseEntity<Usuario> getId(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(service.buscarUsuario(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<List<Usuario>> get() {
        try {
            return new ResponseEntity<>(service.buscarUsuarioes(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
}
