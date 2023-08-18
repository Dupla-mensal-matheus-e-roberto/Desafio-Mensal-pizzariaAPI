package br.com.uniamerica.Pizzaria.Controller;

import br.com.uniamerica.Pizzaria.DTO.ClienteDTO;
import br.com.uniamerica.Pizzaria.Entity.Cliente;
import br.com.uniamerica.Pizzaria.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/controller")
public class ClienteController {

    @Autowired
    private ClienteService clientService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClientById(@PathVariable Long id) {
        return clientService.getClienteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cliente> createClient(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(clientService.createCliente(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateClient(@PathVariable Long id, @RequestBody Cliente cliente) {
        if (!id.equals(cliente.getId_cliente())) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(clientService.updateCliente(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }
}
