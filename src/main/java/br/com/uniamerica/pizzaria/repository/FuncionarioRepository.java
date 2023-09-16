package br.com.uniamerica.pizzaria.repository;

import br.com.uniamerica.pizzaria.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
