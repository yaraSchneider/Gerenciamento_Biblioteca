package net.weg.biblioteca.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.weg.biblioteca.model.Autor;
import net.weg.biblioteca.model.Livro;
import net.weg.biblioteca.service.AutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor")
@AllArgsConstructor
public class AutorController {

    private AutorService service;


    @PostMapping("/post")
    @Operation(summary = "Adicionar Autor:", description = "Postar autor no banco de dados")
    @ApiResponse(responseCode = "201", description = "Livro criado com sucesso", content = @Content(schema = @Schema(implementation = Livro.class)))
    @ApiResponse(responseCode = "400", description = "Requisição inválida")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public ResponseEntity<Autor> postAutor(@RequestBody Autor autor) {
        try {
            return new ResponseEntity<>(service.adicionarAutor(autor), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/put/{id}")
    @Tag(name = "Autor", description = "Operações relacionadas a autor")
    @Operation(summary = "Editor de autor:", description = "Retorna o autor que foi editado")
    public ResponseEntity<Autor> putAutor(@RequestBody Autor autor, @PathVariable Integer id) {
        try {
            return new ResponseEntity<>(service.atualizarAutor(autor, id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    @Tag(name = "Autor", description = "Operações relacionadas a autor")
    @Operation(summary = "Deletar o autor:", description = "Deleta o autor que foi criado")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        try {
            service.deletarAutor(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Tag(name = "Autor", description = "Operações relacionadas a autor")
    @Operation(summary = "Busacar autor:", description = "Retoma o id do autor que está buscando")
    @GetMapping("/getId/{id}")
    public ResponseEntity<Autor> getId(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(service.buscarAutor(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Buscar Autor", description = "Retorna o autor que foi criado")
    @ApiResponse(responseCode = "201", description = "Autor criado com sucesso",
            content = @Content(schema = @Schema(implementation = Livro.class),
                    examples = @ExampleObject(value = "{\"id\": 1, \"Nome\": \"Rick Riordan\"}")))
    @GetMapping("/get")
    public ResponseEntity<List<Autor>> get() {
        try {
            return new ResponseEntity<>(service.buscarAutores(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
