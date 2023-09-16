package br.com.uniamerica.pizzaria.repository;

import br.com.uniamerica.pizzaria.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}
