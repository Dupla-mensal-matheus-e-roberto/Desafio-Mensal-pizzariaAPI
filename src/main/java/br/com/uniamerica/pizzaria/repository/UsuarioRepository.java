package br.com.uniamerica.pizzaria.repository;

import br.com.uniamerica.pizzaria.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
