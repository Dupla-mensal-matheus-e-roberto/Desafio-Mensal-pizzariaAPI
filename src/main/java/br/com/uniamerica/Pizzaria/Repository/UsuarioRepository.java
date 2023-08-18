package br.com.uniamerica.Pizzaria.Repository;

import br.com.uniamerica.Pizzaria.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
