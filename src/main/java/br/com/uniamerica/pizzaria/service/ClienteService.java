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

        Assert.isTrue(id != null, "Insira um ID válido");

        Cliente clienteTmp = clienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado!"));
        return toDTO(clienteTmp);
    }

    public String createCliente(ClienteDTO cliente) {

       Assert.isTrue(cliente.getNome() != null, "Insira um nome válido!");
       Assert.isTrue(cliente.getNome().length() > 2, "Insira um nome válido!");
       Assert.isTrue(cliente.getEndereco() != null, "Insira um endereço válido!");

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
        return clienteDto;
    }

    public Cliente toCliente(ClienteDTO clienteDTO){
        Cliente novoCliente = new Cliente();
        novoCliente.setIdCliente(clienteDTO.getIdCliente());
        novoCliente.setNome(clienteDTO.getNome());
        novoCliente.setEndereco(clienteDTO.getEndereco());
        return novoCliente;
    }

}
