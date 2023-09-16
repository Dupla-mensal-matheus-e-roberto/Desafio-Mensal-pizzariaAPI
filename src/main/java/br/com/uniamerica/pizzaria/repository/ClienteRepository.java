package br.com.uniamerica.pizzaria.repository;

import br.com.uniamerica.pizzaria.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
