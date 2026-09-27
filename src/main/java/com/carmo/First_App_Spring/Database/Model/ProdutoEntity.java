package com.carmo.First_App_Spring.Database.Model;


import lombok.*;

@Getter //Cria metodos Getters
@Setter //Cria metodos Setters
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProdutoEntity {

    private Integer id;
    private String nome;
    private float preco;
    private Integer quantidade;
}
