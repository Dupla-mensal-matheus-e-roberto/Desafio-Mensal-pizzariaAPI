package br.com.uniamerica.Pizzaria.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

public class ClienteDTO {

    @Getter @Setter
    private Long id_cliente;

    @Getter @Setter
    private String nome;

    @Getter @Setter
    private String endereco;

    private Long id_usuario;

    public ClienteDTO(){}

    public long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public ClienteDTO(Long id_cliente, String nome, String endereco, Long id_usuario) {
        this.id_cliente = id_cliente;
        this.nome = nome;
        this.endereco = endereco;
        this.id_usuario = id_usuario;
    }
}
