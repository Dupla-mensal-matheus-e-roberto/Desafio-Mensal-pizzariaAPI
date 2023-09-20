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

        Funcionario funcionarioTmp = funcionarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Funcionario não encontrado!"));

        return toDTO(funcionarioTmp);
    }

    public String createFuncionario(FuncionarioDTO funcionario) {

        Funcionario funcionarioTmp = toFuncionario(funcionario);

        funcionarioRepository.save(funcionarioTmp);

        return "Funcionario criado com sucesso!";
    }

    public String updateFuncionario(FuncionarioDTO funcionario){

        funcionarioRepository.save(toFuncionario(funcionario));

        return "Funcionario editado com sucesso!";
    }

    public void deleteFuncionario(Long id){
        funcionarioRepository.deleteById(id);
    }

    public FuncionarioDTO toDTO(Funcionario funcionario){
        FuncionarioDTO funcionarioDto = new FuncionarioDTO();
        funcionarioDto.setIdFuncionario(funcionario.getIdFuncionario());
        funcionarioDto.setNome(funcionario.getNome());
        funcionarioDto.setUsername(funcionario.getUsername());
        funcionarioDto.setSenha(funcionario.getSenha());
        funcionarioDto.setVendas(funcionario.getVendas());
        return funcionarioDto;
    }

    public Funcionario toFuncionario(FuncionarioDTO funcionarioDTO) {
        Funcionario novoFuncionario = new Funcionario();
        novoFuncionario.setIdFuncionario(funcionarioDTO.getIdFuncionario());
        novoFuncionario.setNome(funcionarioDTO.getNome());
        novoFuncionario.setUsername(funcionarioDTO.getUsername());
        novoFuncionario.setSenha(funcionarioDTO.getUsername());
        novoFuncionario.setVendas(funcionarioDTO.getVendas());
        return novoFuncionario;
    }

}
