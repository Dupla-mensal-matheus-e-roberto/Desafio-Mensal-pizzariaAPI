package br.com.uniamerica.Pizzaria.Controller;


/*
* Endpoint para operações relacionadas a Usuários do sistema
* */

import br.com.uniamerica.Pizzaria.DTO.UsuarioDTO;

import br.com.uniamerica.Pizzaria.Entity.Usuario;
import br.com.uniamerica.Pizzaria.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    /* [+] Get All [+] */

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getAllUsuarios(){

        return ResponseEntity.ok(usuarioService.getAllUsuarios());

    }

    /* [+] CADASTRAR [+] */

    @PostMapping
    public ResponseEntity<String> createUsuario(@RequestBody UsuarioDTO usuario){
        try{
            return ResponseEntity.ok(usuarioService.createUsuario(usuario));
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    /* [+] ATUALIZAR [+] */

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
        if(!id.equals(usuario.getId_usuario())) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(usuarioService.updateUsuario(usuario));
    }

    /* [+] DELETAR [+] */

    public ResponseEntity<String> deleteUsuario(@PathVariable Long id){
        try {
            usuarioService.deleteUsuario(id);
            return ResponseEntity.ok("Usuario deletado com sucesso");
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


}
