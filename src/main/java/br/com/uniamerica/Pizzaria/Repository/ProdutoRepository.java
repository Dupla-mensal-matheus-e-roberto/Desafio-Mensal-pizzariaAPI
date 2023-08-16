package br.com.uniamerica.Pizzaria.Repository;

import br.com.uniamerica.Pizzaria.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
}
