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
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    /* [+] Get All [+] */

    @GetMapping("/all")
    public ResponseEntity<List<UsuarioDTO>> getAllUsuarios(){

        return ResponseEntity.ok(usuarioService.getAllUsuarios());

    }

    /*[+] Get By Id [+]*/

    @GetMapping("/findById/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable("id") Long id){
        try{
            return ResponseEntity.ok(this.usuarioService.findById(id));
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    /* [+] CADASTRAR [+] */

    @PostMapping("/criar")
    public ResponseEntity<String> createUsuario(@RequestBody UsuarioDTO usuario){
        try{
            return ResponseEntity.ok(usuarioService.createUsuario(usuario));
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    /* [+] ATUALIZAR [+] */

    @PutMapping("/editar/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
        if(!id.equals(usuario.getId_usuario())) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(usuarioService.updateUsuario(usuario));
    }

    /* [+] DELETAR [+] */

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable Long id){
        try {
            usuarioService.deleteUsuario(id);
            return ResponseEntity.ok("Usuario deletado com sucesso");
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


}
