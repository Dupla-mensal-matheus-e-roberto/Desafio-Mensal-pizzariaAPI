package br.com.uniamerica.pizzaria.repository;

import br.com.uniamerica.pizzaria.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
