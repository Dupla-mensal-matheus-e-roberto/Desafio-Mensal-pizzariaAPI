package br.com.uniamerica.Pizzaria.DTO;


import lombok.Getter;
import lombok.Setter;

public class UsuarioDTO {

    @Getter @Setter
    private Long id_usuario;

    @Getter @Setter
    private String login;

    @Getter @Setter
    private String senha;

    public UsuarioDTO(){}

    public UsuarioDTO(Long id_usuario, String login, String senha) {
        this.id_usuario = id_usuario;
        this.login = login;
        this.senha = senha;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
