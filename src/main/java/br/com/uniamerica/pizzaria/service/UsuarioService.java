package br.com.uniamerica.pizzaria.service;

import br.com.uniamerica.pizzaria.entity.Usuario;
import br.com.uniamerica.pizzaria.repository.LoginRepository;
import br.com.uniamerica.pizzaria.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuarioOptional = loginRepository.findByUsername(username);

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();

            UserDetails userDetails = User.builder()
                    .username(usuario.getUsername())
                    .password(usuario.getPassword())
                    .roles("ROLE_USER")
                    .build();

            return userDetails;
        }

        throw new UsernameNotFoundException("Não encontrado");
    }

    public Usuario criarUsuario(Usuario user) throws Exception {

        Optional<Usuario> username = loginRepository.findByUsername(user.getUsername());

        if(username.isPresent()){
            throw new Exception("Username está em uso");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        user.setRole(user.getRole().toUpperCase());

        var usersalvo = usuarioRepository.save(user);


        return user;
    }

}
