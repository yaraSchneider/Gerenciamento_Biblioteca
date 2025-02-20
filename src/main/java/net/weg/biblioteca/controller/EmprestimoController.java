package net.weg.biblioteca.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import net.weg.biblioteca.dto.EmprestimoRequestDTO;
import net.weg.biblioteca.model.Emprestimo;
import net.weg.biblioteca.model.Emprestimo;
import net.weg.biblioteca.model.Livro;
import net.weg.biblioteca.service.EmprestimoService;
import net.weg.biblioteca.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
@AllArgsConstructor
public class EmprestimoController {

    private EmprestimoService service;

    @PostMapping("/post")
    @Operation(summary = "Livro Emprestado", description = "Mostrar caso esteja ou não no banco de dados")
    @ApiResponse(responseCode = "201", description = "Livro criado com sucesso", content = @Content(schema = @Schema(implementation = Livro.class)))
    @ApiResponse(responseCode = "400", description = "Requisição inválida")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public ResponseEntity<Emprestimo> postEmprestimo(@RequestBody EmprestimoRequestDTO emprestimoRequestDTO) {
        try {
            return new ResponseEntity<>(service.adicionarEmprestimo(emprestimoRequestDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Emprestimo> putEmprestimo(@RequestBody EmprestimoRequestDTO emprestimoRequestDTO, @PathVariable Integer id) {
        try {
            return new ResponseEntity<>(service.atualizarEmprestimo(emprestimoRequestDTO, id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        try {
            service.deletarEmprestimo(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getId/{id}")
    public ResponseEntity<Emprestimo> getId(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(service.buscarEmprestimo(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<List<Emprestimo>> get() {
        try {
            return new ResponseEntity<>(service.buscarEmprestimoes(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
