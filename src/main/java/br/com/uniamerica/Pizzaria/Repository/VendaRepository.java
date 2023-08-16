package br.com.uniamerica.Pizzaria.Repository;

import br.com.uniamerica.Pizzaria.Entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}
