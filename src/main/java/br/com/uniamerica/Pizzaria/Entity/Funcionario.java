package br.com.uniamerica.Pizzaria.Entity;

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
    private Long id_funcionario;
    @Column(name = "nome")
    private String nome;
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario id_usuario;
    @OneToMany(mappedBy = "funcionario")
    private List<Venda> vendas;

}
