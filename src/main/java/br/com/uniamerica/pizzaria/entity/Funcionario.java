package br.com.uniamerica.pizzaria.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "funcionarios", schema = "public")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcionario")
    private Long idFuncionario;
    @Column(name = "nome")
    private String nome;
    @Column(name = "username")
    private String username;
    @Column(name = "senha")
    private String senha;
    @JsonIgnore
    @OneToMany(mappedBy = "funcionario")
    private List<Venda> vendas;


}
