package br.com.uniamerica.pizzaria.service;

import br.com.uniamerica.pizzaria.dto.VendaDTO;
import br.com.uniamerica.pizzaria.entity.Venda;
import br.com.uniamerica.pizzaria.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;
    private Venda venda;

    public List<VendaDTO> getAll(){
        return vendaRepository.findAll().stream().map(this::toVendaDto).toList();
    }

    public VendaDTO findById(Long id){
        Venda vendaBanco = this.vendaRepository.findById(id).orElse(null);

        Assert.isTrue(vendaBanco != null, "Venda Inválido");

        return toVendaDto(vendaBanco);
    }

    public VendaDTO criar(VendaDTO vendaDTO){

        Venda vendaTmp = toVenda(vendaDTO);

        Venda venda2 = this.vendaRepository.save(vendaTmp);

        return this.toVendaDto(venda2);
    }

    public VendaDTO editar(VendaDTO vendaDTO, Long id){

        Venda vendasalva = this.vendaRepository.findById(id).orElse(null);

        Venda vendaTmp = toVenda(vendaDTO);

        vendasalva = vendaTmp;

        Venda vendaeditado = vendaRepository.save(vendasalva);

        return this.toVendaDto(vendaeditado);
    }

    public void deletar(Long id){
        venda = this.vendaRepository.findById(id).orElse(null);

        Assert.isTrue(venda != null, "Venda Inválido ");

        this.vendaRepository.delete(venda);
    }

    public VendaDTO toVendaDto(Venda venda){
        VendaDTO vendaDTO = new VendaDTO();
        vendaDTO.setIdVenda(venda.getIdVenda());
        vendaDTO.setFuncionario(venda.getFuncionario());
        vendaDTO.setPedido(venda.getPedido());
        vendaDTO.setTipoEntrega(venda.getTipoEntrega());
        vendaDTO.setTipoPagamento(venda.getTipoPagamento());

        return vendaDTO;
    }

    public Venda toVenda(VendaDTO vendaDTO){
        venda = new Venda();
        venda.setIdVenda(vendaDTO.getIdVenda());
        venda.setFuncionario(vendaDTO.getFuncionario());
        venda.setPedido(vendaDTO.getPedido());
        venda.setTipoEntrega(vendaDTO.getTipoEntrega());
        venda.setTipoPagamento(vendaDTO.getTipoPagamento());

        return venda;
    }
}
