package br.com.uniamerica.Pizzaria.Controller;

import br.com.uniamerica.Pizzaria.DTO.ClienteDTO;
import br.com.uniamerica.Pizzaria.DTO.FuncionarioDTO;
import br.com.uniamerica.Pizzaria.Entity.Funcionario;
import br.com.uniamerica.Pizzaria.Service.FuncionarioService;
import jdk.javadoc.doclet.Reporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;



/*
 * Endpoint para operações relacionadas a Funcionários
 * */

@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    /* [+] Get All [+] */

    @GetMapping
    public ResponseEntity<List<FuncionarioDTO>> getAllFuncionarios(){

        return ResponseEntity.ok(funcionarioService.getAllFuncionarios());

    }

    /* [+] CADASTRAR [+] */

    @PostMapping
    public ResponseEntity<String> createFuncionario(@RequestBody FuncionarioDTO funcionario){
        try{
            return ResponseEntity.ok(funcionarioService.createFuncionario(funcionario));
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    /* [+] ATUALIZAR [+] */

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> updateFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario){
       if(!id.equals(funcionario.getId_funcionario())) {
        return ResponseEntity.badRequest().build();
       }
       return ResponseEntity.ok(funcionarioService.updateFuncionario(funcionario));
    }

    /* [+] DELETAR [+] */
    public ResponseEntity<String> deleteFuncionario(@PathVariable Long id){
        try {
            funcionarioService.deleteFuncionario(id);
            return ResponseEntity.ok("Funcionario deletado com sucesso");
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
