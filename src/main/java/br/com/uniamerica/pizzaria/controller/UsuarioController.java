package br.com.uniamerica.pizzaria.controller;

import br.com.uniamerica.pizzaria.entity.Usuario;
import br.com.uniamerica.pizzaria.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> criarUsuario(@RequestBody Usuario user) throws Exception {
        try {
            Usuario usuario = usuarioService.criarUsuario(user);
            return ResponseEntity.ok(usuario);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
