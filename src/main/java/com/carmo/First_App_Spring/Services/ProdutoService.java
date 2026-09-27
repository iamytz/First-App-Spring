package com.carmo.First_App_Spring.Services;

import com.carmo.First_App_Spring.Database.Model.ProdutoEntity;
import com.carmo.First_App_Spring.Dtos.ProdutoDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

//    private static final List<ProdutoEntity> PRODUTOS = List.of(
//            new ProdutoEntity(1,"Notebook",5000f,10),
//            new ProdutoEntity(2,"Iphone",7000f,10),
//            new ProdutoEntity(3,"Mouse",5000f,10)
//    );

    private static final List<ProdutoEntity> PRODUTOS = new ArrayList<>();  //cria lista vazia

    static {
        PRODUTOS.add(ProdutoEntity.builder()
                .id(1).nome("Notebook").preco(5000f).quantidade(10).build());

        PRODUTOS.add(ProdutoEntity.builder()
                .id(2).nome("IPhone").preco(7000f).quantidade(10).build());

        PRODUTOS.add(ProdutoEntity.builder()
                        .id(3).nome("Mouse").preco(5000f).quantidade(10).build());
    }

    public List<ProdutoEntity> findAll() {
        return new ArrayList<>(PRODUTOS);
    }
    //criando index
    Integer idx = PRODUTOS.stream().mapToInt(ProdutoEntity::getId).max().orElse(0)+1;
    public ProdutoEntity criarProduto(ProdutoDto dto) {
        ProdutoEntity novoProduto = ProdutoEntity.builder()
                .id(idx)
                .nome(dto.getNome())
                .preco(dto.getPreco())
                .quantidade(dto.getQuantidade())
                .build();

        PRODUTOS.add(novoProduto);
        return novoProduto;
    }



    public ResponseEntity<String> alterarTudo(Integer id, ProdutoDto dto){
        ProdutoEntity produtoAlterado = PRODUTOS.stream()   //passa por cada um da lista
                .filter(produto -> produto.getId().equals(id))  //ao passar em cada da lista filtra os que tem o id igual do parametro
                .findFirst()        //para e retorna o primeiro
                .orElse(null);  // se nao retorna null

        if (produtoAlterado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        } else {
            produtoAlterado.setNome(dto.getNome());
            produtoAlterado.setPreco(dto.getPreco());
            produtoAlterado.setQuantidade(dto.getQuantidade());
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

    }


}
