package br.com.uniamerica.Pizzaria.DTO;

import br.com.uniamerica.Pizzaria.Entity.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {
    private Long id_cliente;
    private String nome;
    private String endereco;
    private Usuario id_usuario;

    public ClienteDTO(Long id_cliente, String nome, String endereco, Usuario id_usuario) {
        this.id_cliente = id_cliente;
        this.nome = nome;
        this.endereco = endereco;
        this.id_usuario = id_usuario;
    }

    public ClienteDTO() {

    }
}
