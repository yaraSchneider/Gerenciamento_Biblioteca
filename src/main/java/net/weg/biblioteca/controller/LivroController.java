package net.weg.biblioteca.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import net.weg.biblioteca.dto.LivroRequestDTO;
import net.weg.biblioteca.model.Livro;
import net.weg.biblioteca.model.Livro;
import net.weg.biblioteca.service.LivroService;
import net.weg.biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;






import java.util.List;

@RestController
@RequestMapping("/livro")
@AllArgsConstructor
public class LivroController {

    private LivroService service;

    @PostMapping("/post")
    @Operation(summary = "Adicionar Livro:", description = "Postar livro no banco de dados")
    @ApiResponse(responseCode = "201", description = "Livro criado com sucesso", content = @Content(schema = @Schema(implementation = Livro.class)))
    @ApiResponse(responseCode = "400", description = "Requisição inválida")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public ResponseEntity<Livro> postLivro(@RequestBody LivroRequestDTO livroRequestDTO) {
        try {
            return new ResponseEntity<>(service.adicionarLivro(livroRequestDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Livro> putLivro(@RequestBody LivroRequestDTO livroRequestDTO, @PathVariable Integer id) {
        try {
            return new ResponseEntity<>(service.atualizarLivro(livroRequestDTO, id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        try {
            service.deletarLivro(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getId/{id}")
    public ResponseEntity<Livro> getId(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(service.buscarLivro(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<List<Livro>> get() {
        try {
            return new ResponseEntity<>(service.buscarLivroes(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
