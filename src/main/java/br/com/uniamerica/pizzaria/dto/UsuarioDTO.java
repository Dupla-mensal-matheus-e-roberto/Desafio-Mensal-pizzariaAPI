package br.com.uniamerica.pizzaria.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {
    private Long id;
    private String username;
    private String token;
    private String role;
}
