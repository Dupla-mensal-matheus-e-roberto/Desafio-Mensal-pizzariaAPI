package br.com.uniamerica.Pizzaria.Service;


import br.com.uniamerica.Pizzaria.DTO.UsuarioDTO;
import br.com.uniamerica.Pizzaria.Entity.Usuario;
import br.com.uniamerica.Pizzaria.Repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    private Usuario usuario;

    public List<UsuarioDTO> getAllUsuarios(){
        return usuarioRepository.findAll().stream().map(this::toDTO).toList();
    }

    public UsuarioDTO findById(Long id){

        Assert.isTrue(id != null, "Insira um ID válido");
        Usuario usuario_tmp = usuarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuario não encontrado!"));
        return toDTO(usuario_tmp);
    }

    public String createUsuario(UsuarioDTO usuario) {

        Assert.isTrue(usuario.getLogin() != null, "Insira um Login válido!");
        Assert.isTrue(usuario.getSenha() != null, "Insira uma senha válida!");

        Usuario usuario_tmp = toUsuario(usuario);

        usuarioRepository.save(usuario_tmp);

        return "Usuario criado com sucesso!";
    }

    public Usuario updateUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Long id){
        usuarioRepository.deleteById(id);
    }

    public UsuarioDTO toDTO(Usuario usuario){
        UsuarioDTO usuario_dto = new UsuarioDTO();
        usuario_dto.setId_usuario(usuario.getId_usuario());
        usuario_dto.setLogin(usuario.getLogin());
        usuario_dto.setSenha(usuario.getSenha());
        return usuario_dto;
    }

    public Usuario toUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setId_usuario(usuarioDTO.getId_usuario());
        usuario.setLogin(usuarioDTO.getLogin());
        usuario.setSenha(usuarioDTO.getSenha());
        return usuario;
    }


}
