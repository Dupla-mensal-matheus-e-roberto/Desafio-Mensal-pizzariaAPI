package br.com.uniamerica.Pizzaria.Repository;

import br.com.uniamerica.Pizzaria.Entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
