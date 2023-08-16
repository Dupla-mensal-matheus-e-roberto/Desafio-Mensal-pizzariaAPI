package br.com.uniamerica.Pizzaria.Repository;

import br.com.uniamerica.Pizzaria.Entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}
