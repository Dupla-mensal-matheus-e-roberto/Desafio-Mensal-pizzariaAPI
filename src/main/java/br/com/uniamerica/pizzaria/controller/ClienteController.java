package br.com.uniamerica.pizzaria.controller;

import br.com.uniamerica.pizzaria.dto.ClienteDTO;
import br.com.uniamerica.pizzaria.entity.Cliente;
import br.com.uniamerica.pizzaria.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;



/*
* Endpoint para operações relacionadas a Clientes
* */

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clientService;

    /* [+] Get All [+]*/

    @GetMapping("/all")
    public ResponseEntity<List<ClienteDTO>> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClientes());
    }

    /*[+] Get By Id [+]*/

    @GetMapping("/findById/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable("id") Long id){
        try{
            return ResponseEntity.ok(this.clientService.findById(id));
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    /* [+] CADASTRAR [+]  */

    @PostMapping("/criar")
    public ResponseEntity<String> createClient(@RequestBody ClienteDTO cliente) {
        try {
            return ResponseEntity.ok(clientService.createCliente(cliente));

        } catch(Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    /* [+] ATUALIZAR [+] */

    @PutMapping("/editar/{id}")
    public ResponseEntity<Cliente> updateClient(@PathVariable Long id, @RequestBody Cliente cliente) {
        if (!id.equals(cliente.getIdCliente())) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(clientService.updateCliente(cliente));
    }

    /* [+] DELETAR [+] */

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }
}
