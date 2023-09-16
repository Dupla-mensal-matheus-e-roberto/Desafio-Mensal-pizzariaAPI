package br.com.uniamerica.pizzaria.service;


import br.com.uniamerica.pizzaria.dto.FuncionarioDTO;
import br.com.uniamerica.pizzaria.entity.Funcionario;
import br.com.uniamerica.pizzaria.repository.FuncionarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<FuncionarioDTO> getAllFuncionarios() {
        return funcionarioRepository.findAll().stream().map(this::toDTO).toList();
    }

    public FuncionarioDTO findById(Long id){
        Assert.isTrue(id != null, "Insira um ID válido");

        Funcionario funcionarioTmp = funcionarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Funcionario não encontrado!"));

        return toDTO(funcionarioTmp);
    }

    public String createFuncionario(FuncionarioDTO funcionario) {

        Assert.isTrue(funcionario.getNome() != null, "Insira um nome válido!");
        Assert.isTrue(funcionario.getNome().length() > 2, "Insira um nome válido!");

        Funcionario funcionarioTmp = toFuncionario(funcionario);

        funcionarioRepository.save(funcionarioTmp);

        return "Funcionario criado com sucesso!";
    }

    public Funcionario updateFuncionario(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    public void deleteFuncionario(Long id){
        funcionarioRepository.deleteById(id);
    }

    public FuncionarioDTO toDTO(Funcionario funcionario){
        FuncionarioDTO funcionarioDto = new FuncionarioDTO();
        funcionarioDto.setIdFuncionario(funcionario.getIdFuncionario());
        funcionarioDto.setNome(funcionario.getNome());
        funcionarioDto.setIdUsuario(funcionario.getIdUsuario());
        return funcionarioDto;
    }

    public Funcionario toFuncionario(FuncionarioDTO funcionarioDTO) {
        Funcionario novoFuncionario = new Funcionario();
        novoFuncionario.setIdFuncionario(funcionarioDTO.getIdFuncionario());
        novoFuncionario.setNome(funcionarioDTO.getNome());
        novoFuncionario.setIdUsuario(funcionarioDTO.getIdUsuario());
        return novoFuncionario;
    }

}
