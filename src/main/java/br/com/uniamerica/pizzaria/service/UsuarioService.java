package br.com.uniamerica.pizzaria.service;


import br.com.uniamerica.pizzaria.dto.UsuarioDTO;
import br.com.uniamerica.pizzaria.entity.Usuario;
import br.com.uniamerica.pizzaria.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> getAllUsuarios(){
        return usuarioRepository.findAll().stream().map(this::toDTO).toList();
    }

    public UsuarioDTO findById(Long id){

        Assert.isTrue(id != null, "Insira um ID válido");
        Usuario usuarioTmp = usuarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuario não encontrado!"));
        return toDTO(usuarioTmp);
    }

    public String createUsuario(UsuarioDTO usuario) {

        Assert.isTrue(usuario.getLogin() != null, "Insira um Login válido!");
        Assert.isTrue(usuario.getSenha() != null, "Insira uma senha válida!");

        Usuario usuarioTmp = toUsuario(usuario);

        usuarioRepository.save(usuarioTmp);

        return "Usuario criado com sucesso!";
    }

    public Usuario updateUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Long id){
        usuarioRepository.deleteById(id);
    }

    public UsuarioDTO toDTO(Usuario usuario){
        UsuarioDTO usuarioDto = new UsuarioDTO();
        usuarioDto.setIdUsuario(usuario.getIdUsuario());
        usuarioDto.setLogin(usuario.getLogin());
        usuarioDto.setSenha(usuario.getSenha());
        return usuarioDto;
    }

    public Usuario toUsuario(UsuarioDTO usuarioDTO) {
        Usuario novoUsuario = new Usuario();
        novoUsuario.setIdUsuario(usuarioDTO.getIdUsuario());
        novoUsuario.setLogin(usuarioDTO.getLogin());
        novoUsuario.setSenha(usuarioDTO.getSenha());
        return novoUsuario;
    }


}
