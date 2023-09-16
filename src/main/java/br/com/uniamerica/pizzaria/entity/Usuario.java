package br.com.uniamerica.pizzaria.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios", schema = "public")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_usuario")
    private Long idUsuario;
    @Column(name="login")
    private String login;
    @Column(name="senha")
    private String senha;
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Cliente cliente;
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Funcionario funcionario;
}

