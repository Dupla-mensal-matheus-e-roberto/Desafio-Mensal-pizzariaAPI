package br.com.uniamerica.pizzaria.repository;

import br.com.uniamerica.pizzaria.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
}
