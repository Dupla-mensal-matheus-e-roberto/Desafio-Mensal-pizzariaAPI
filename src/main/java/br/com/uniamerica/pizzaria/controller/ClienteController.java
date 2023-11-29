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
@CrossOrigin(origins = "http://localhost:4200")
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
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    /* [+] CADASTRAR [+]  */

    @PostMapping("/criar")
    public ResponseEntity<ClienteDTO> createClient(@RequestBody ClienteDTO cliente) {
        try {
            ClienteDTO clienteSalvo = clientService.createCliente(cliente);
            return new ResponseEntity<>(clienteSalvo, HttpStatus.OK);
        } catch(Exception e){
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    /* [+] ATUALIZAR [+] */

    @PutMapping("/editar/{id}")
    public ResponseEntity<ClienteDTO> updateClient(@PathVariable Long id, @RequestBody ClienteDTO cliente) {
        if (!id.equals(cliente.getIdCliente())) {
            return ResponseEntity.badRequest().build();
        }

        ClienteDTO clienteEditar = clientService.updateCliente(cliente, id);
        return new ResponseEntity<>(clienteEditar, HttpStatus.OK);
    }

    /* [+] DELETAR [+] */

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable("id") final Long id) {
        try{
            return ResponseEntity.ok(clientService.deleteCliente(id));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }
}
