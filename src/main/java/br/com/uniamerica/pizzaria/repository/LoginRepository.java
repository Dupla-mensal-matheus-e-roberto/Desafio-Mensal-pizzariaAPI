package br.com.uniamerica.pizzaria.repository;

import br.com.uniamerica.pizzaria.entity.Usuario;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

    public interface LoginRepository extends JpaRepository<Usuario, Long> {
    public Optional<Usuario> findByUsername(String login);
}
