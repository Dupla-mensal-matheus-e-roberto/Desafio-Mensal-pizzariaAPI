package br.com.uniamerica.pizzaria.repository;

import br.com.uniamerica.pizzaria.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}
