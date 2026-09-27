package com.carmo.First_App_Spring.Controllers;

import com.carmo.First_App_Spring.Database.Model.ProdutoEntity;
import com.carmo.First_App_Spring.Dtos.ProdutoDto;
import com.carmo.First_App_Spring.Services.ProdutoService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProdutoController {
    private final ProdutoService service;   //Injeção de Dependencia

    @GetMapping("produtos")    //Lista todos os produtos
    public List<ProdutoEntity> mostrarTodos() {
        return service.findAll();
    }

    @PutMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoEntity criarProduto(@RequestBody ProdutoDto dto) {
    return service.criarProduto(dto);
    }

    @PostMapping("/post/{id}")
    public ResponseEntity<String> alterarProduto(@PathVariable int id, @RequestBody ProdutoDto dto) {
        return service.alterarTudo(id,dto);
    }
}
