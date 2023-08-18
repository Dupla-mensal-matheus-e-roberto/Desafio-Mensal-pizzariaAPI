package br.com.uniamerica.Pizzaria.Service;

import br.com.uniamerica.Pizzaria.DTO.ClienteDTO;
import br.com.uniamerica.Pizzaria.Entity.Cliente;
import br.com.uniamerica.Pizzaria.Repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    private Cliente cliente;

    public List<ClienteDTO> getAllClientes() {
        return clienteRepository.findAll().stream().map(this::toDTO).toList();
    }

    public ClienteDTO findById(Long id) {

        Assert.isTrue(id != null, "Insira um ID válido");

        Cliente cliente_tmp = clienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado!"));
        return toDTO(cliente_tmp);
    }

    public String createCliente(ClienteDTO cliente) {

       Assert.isTrue(cliente.getNome() != null, "Insira um nome válido!");
       Assert.isTrue(cliente.getNome().length() > 2, "Insira um nome válido!");
       Assert.isTrue(cliente.getEndereco() != null, "Insira um endereço válido!");

       Cliente cliente_tmp = toCliente(cliente);

       clienteRepository.save(cliente_tmp);

       return "Cliente criado com sucesso!";

    }

    public Cliente updateCliente(Cliente client) {
        return clienteRepository.save(client);
    }

    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    public ClienteDTO toDTO(Cliente cliente){
        ClienteDTO cliente_dto = new ClienteDTO();
        cliente_dto.setId_cliente(cliente.getId_cliente());
        cliente_dto.setNome(cliente.getNome());
        cliente_dto.setEndereco(cliente.getEndereco());
        cliente_dto.setId_usuario(cliente.getId_usuario());
        return cliente_dto;
    }

    public Cliente toCliente(ClienteDTO cliente_DTO){
        Cliente cliente = new Cliente();
        cliente.setId_cliente(cliente_DTO.getId_cliente());
        cliente.setNome(cliente_DTO.getNome());
        cliente.setEndereco(cliente_DTO.getEndereco());
        cliente.setId_usuario(cliente_DTO.getId_usuario());
        return cliente;
    }

}
