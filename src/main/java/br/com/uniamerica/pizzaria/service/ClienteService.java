package br.com.uniamerica.pizzaria.service;

import br.com.uniamerica.pizzaria.controller.ClienteController;
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

    public ClienteDTO createCliente(ClienteDTO cliente) {

       Cliente clienteTmp = toCliente(cliente);

       Cliente cliente2 = clienteRepository.save(clienteTmp);

       return this.toDTO(cliente2);

    }

    public ClienteDTO updateCliente(ClienteDTO clienteDTO, Long id) {

        Cliente clientesalvo = clienteRepository.findById(id).orElse(null);

        Cliente clienteTmp = toCliente(clienteDTO);

        clientesalvo = clienteTmp;

        Cliente clienteeditado = clienteRepository.save(clientesalvo);

        return this.toDTO(clienteeditado);
    }

    public String deleteCliente(Long id) {
        Cliente clientesalvo = clienteRepository.findById(id).orElse(null);

        this.clienteRepository.delete(clientesalvo);

        return "cliente deletado com sucesso";
    }

    public ClienteDTO toDTO(Cliente cliente){
        ClienteDTO clienteDto = new ClienteDTO();
        clienteDto.setIdCliente(cliente.getIdCliente());
        clienteDto.setNome(cliente.getNome());
        clienteDto.setEndereco(cliente.getEndereco());
        clienteDto.setUsuario(cliente.getIdUsuario());
        clienteDto.setPedidos(cliente.getPedidos());
        return clienteDto;
    }

    public Cliente toCliente(ClienteDTO clienteDTO){
        Cliente novoCliente = new Cliente();
        novoCliente.setIdCliente(clienteDTO.getIdCliente());
        novoCliente.setNome(clienteDTO.getNome());
        novoCliente.setEndereco(clienteDTO.getEndereco());
        novoCliente.setIdUsuario(clienteDTO.getUsuario());
        novoCliente.setPedidos(clienteDTO.getPedidos());
        return novoCliente;
    }

}
