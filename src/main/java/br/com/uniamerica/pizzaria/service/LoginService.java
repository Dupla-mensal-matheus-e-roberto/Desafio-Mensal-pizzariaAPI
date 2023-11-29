package br.com.uniamerica.pizzaria.service;

import br.com.uniamerica.pizzaria.config.JwtServiceGenerator;
import br.com.uniamerica.pizzaria.dto.LoginDTO;
import br.com.uniamerica.pizzaria.dto.UsuarioDTO;
import br.com.uniamerica.pizzaria.entity.Usuario;
import br.com.uniamerica.pizzaria.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepository repository;
    @Autowired
    private JwtServiceGenerator jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    public UsuarioDTO logar(LoginDTO loginDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getUsername(),
                        loginDTO.getPassword()
                )
        );
        Usuario usuario = repository.findByUsername(loginDTO.getUsername()).orElseThrow();
        var jwtToken = jwtService.generateToken(usuario);

        return toUserDTO(usuario, jwtToken);
    }

    private UsuarioDTO toUserDTO(Usuario usuario, String token) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setRole(usuario.getRole());
        usuarioDTO.setToken(token);
        usuarioDTO.setUsername(usuario.getUsername());
        return usuarioDTO;
    }

}
