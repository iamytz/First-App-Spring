package com.carmo.First_App_Spring.Dtos;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProdutoDto {
    private String nome;
    private float preco;
    private Integer quantidade;

}
