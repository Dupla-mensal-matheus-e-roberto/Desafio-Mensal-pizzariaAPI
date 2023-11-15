package br.com.uniamerica.pizzaria.service;


import br.com.uniamerica.pizzaria.dto.FuncionarioDTO;
import br.com.uniamerica.pizzaria.entity.Cliente;
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

    public FuncionarioDTO createFuncionario(FuncionarioDTO funcionario) {

        Funcionario funcionarioTmp = toFuncionario(funcionario);

        Funcionario funcionario1 = funcionarioRepository.save(funcionarioTmp);

        return toDTO(funcionario1);
    }

    public FuncionarioDTO updateFuncionario(FuncionarioDTO funcionario, Long id){

        Funcionario funcionariosalvo = funcionarioRepository.findById(id).orElse(null);

        Funcionario funcionarioTmp = toFuncionario(funcionario);

        funcionariosalvo = funcionarioTmp;

        Funcionario funcionario1 = funcionarioRepository.save(funcionariosalvo);

        return toDTO(funcionario1);
    }

    public String deleteFuncionario(Long id){
        Funcionario funcionario = this.funcionarioRepository.findById(id).orElse(null);

        funcionarioRepository.deleteById(id);

        return "funcionario deletado com sucesso";
    }

    public FuncionarioDTO toDTO(Funcionario funcionario){
        FuncionarioDTO funcionarioDto = new FuncionarioDTO();
        funcionarioDto.setIdFuncionario(funcionario.getIdFuncionario());
        funcionarioDto.setNome(funcionario.getNome());
        funcionarioDto.setUsuario(funcionario.getIdUsuario());
        funcionarioDto.setVendas(funcionario.getVendas());
        return funcionarioDto;
    }

    public Funcionario toFuncionario(FuncionarioDTO funcionarioDTO) {
        Funcionario novoFuncionario = new Funcionario();
        novoFuncionario.setIdFuncionario(funcionarioDTO.getIdFuncionario());
        novoFuncionario.setNome(funcionarioDTO.getNome());
        novoFuncionario.setIdUsuario(funcionarioDTO.getUsuario());
        novoFuncionario.setVendas(funcionarioDTO.getVendas());
        return novoFuncionario;
    }

}
