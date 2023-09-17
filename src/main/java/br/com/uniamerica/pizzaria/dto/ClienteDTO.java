package br.com.uniamerica.pizzaria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
    private Long idCliente;
    private String nome;
    private String endereco;
    private String login;
    private String senha;
}
