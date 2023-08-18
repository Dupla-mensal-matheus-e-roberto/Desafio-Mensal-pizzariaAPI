package br.com.uniamerica.Pizzaria.Service;


import br.com.uniamerica.Pizzaria.DTO.ClienteDTO;
import br.com.uniamerica.Pizzaria.DTO.FuncionarioDTO;
import br.com.uniamerica.Pizzaria.Entity.Cliente;
import br.com.uniamerica.Pizzaria.Entity.Funcionario;
import br.com.uniamerica.Pizzaria.Repository.FuncionarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    private Funcionario funcionario;

    public List<FuncionarioDTO> getAllFuncionarios() {
        return funcionarioRepository.findAll().stream().map(this::toDTO).toList();
    }

    public FuncionarioDTO findById(Long id){
        Assert.isTrue(id != null, "Insira um ID válido");

        Funcionario funcionario_tmp = funcionarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Funcionario não encontrado!"));

        return toDTO(funcionario_tmp);
    }

    public String createFuncionario(FuncionarioDTO funcionario) {

        Assert.isTrue(funcionario.getNome() != null, "Insira um nome válido!");
        Assert.isTrue(funcionario.getNome().length() > 2, "Insira um nome válido!");

        Funcionario funcionario_tmp = toFuncionario(funcionario);

        funcionarioRepository.save(funcionario_tmp);

        return "Funcionario criado com sucesso!";
    }

    public Funcionario updateFuncionario(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    public void deleteFuncionario(Long id){
        funcionarioRepository.deleteById(id);
    }

    public FuncionarioDTO toDTO(Funcionario funcionario){
        FuncionarioDTO funcionario_dto = new FuncionarioDTO();
        funcionario_dto.setId_funcionario(funcionario.getId_funcionario());
        funcionario_dto.setNome(funcionario.getNome());
        funcionario_dto.setId_usuario(funcionario.getId_usuario());
        return funcionario_dto;
    }

    public Funcionario toFuncionario(FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = new Funcionario();
        funcionario.setId_funcionario(funcionarioDTO.getId_funcionario());
        funcionario.setNome(funcionarioDTO.getNome());
        funcionario.setId_usuario(funcionarioDTO.getId_usuario());
        return funcionario;
    }

}
