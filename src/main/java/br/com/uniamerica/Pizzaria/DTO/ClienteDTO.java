package br.com.uniamerica.Pizzaria.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

public class ClienteDTO {


    private int id_cliente;

    @Getter @Setter
    private String nome;

    @Getter @Setter
    private String endereco;


    private int id_usuario;

    public ClienteDTO(){}

    public ClienteDTO(int id_cliente, String nome, String endereco, int id_usuario) {
        this.id_cliente = id_cliente;
        this.nome = nome;
        this.endereco = endereco;
        this.id_usuario = id_usuario;
    }
}
