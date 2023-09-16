package br.com.uniamerica.Pizzaria.DTO;

import br.com.uniamerica.Pizzaria.Entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
    private Long id_cliente;
    private String nome;
    private String endereco;
    private Usuario id_usuario;

}
