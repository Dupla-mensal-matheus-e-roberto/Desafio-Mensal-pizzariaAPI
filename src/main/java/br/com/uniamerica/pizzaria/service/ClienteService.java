package br.com.uniamerica.pizzaria.service;

import br.com.uniamerica.pizzaria.dto.ClienteDTO;
import br.com.uniamerica.pizzaria.entity.Cliente;
import br.com.uniamerica.pizzaria.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteDTO> getAllClientes() {
        return clienteRepository.findAll().stream().map(this::toDTO).toList();
    }

    public ClienteDTO findById(Long id) {

        Cliente clienteTmp = clienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado!"));
        return toDTO(clienteTmp);
    }

    public String createCliente(ClienteDTO cliente) {

       Cliente clienteTmp = toCliente(cliente);

       clienteRepository.save(clienteTmp);

       return "Cliente criado com sucesso!";

    }

    public String updateCliente(ClienteDTO clienteDTO) {

        Cliente clienteTmp = toCliente(clienteDTO);

        clienteRepository.save(clienteTmp);

        return "Cliente editado com sucesso";
    }

    public String deleteCliente(Long id) {
        clienteRepository.deleteById(id);
        return "Cliente deletado com sucesso";
    }

    public ClienteDTO toDTO(Cliente cliente){
        ClienteDTO clienteDto = new ClienteDTO();
        clienteDto.setIdCliente(cliente.getIdCliente());
        clienteDto.setNome(cliente.getNome());
        clienteDto.setEndereco(cliente.getEndereco());
        clienteDto.setUsername(cliente.getUsername());
        clienteDto.setSenha(cliente.getSenha());
        clienteDto.setPedidos(cliente.getPedidos());
        return clienteDto;
    }

    public Cliente toCliente(ClienteDTO clienteDTO){
        Cliente novoCliente = new Cliente();
        novoCliente.setIdCliente(clienteDTO.getIdCliente());
        novoCliente.setNome(clienteDTO.getNome());
        novoCliente.setEndereco(clienteDTO.getEndereco());
        novoCliente.setUsername(clienteDTO.getUsername());
        novoCliente.setSenha(clienteDTO.getSenha());
        novoCliente.setPedidos(clienteDTO.getPedidos());
        return novoCliente;
    }

}
