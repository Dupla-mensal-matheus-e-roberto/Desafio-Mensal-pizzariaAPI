package br.com.uniamerica.Pizzaria.Repository;

import br.com.uniamerica.Pizzaria.DTO.ClienteDTO;
import br.com.uniamerica.Pizzaria.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
