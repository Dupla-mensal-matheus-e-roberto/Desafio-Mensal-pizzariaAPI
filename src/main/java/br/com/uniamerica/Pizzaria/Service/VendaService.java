package br.com.uniamerica.Pizzaria.Service;

import br.com.uniamerica.Pizzaria.DTO.VendaDTO;
import br.com.uniamerica.Pizzaria.Entity.Venda;
import br.com.uniamerica.Pizzaria.Repository.VendaRepository;
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
    private VendaDTO vendaDTO;

    public List<VendaDTO> getAll(){
        List<Venda> listBanco = this.vendaRepository.findAll();
        List<VendaDTO> listDTO = new ArrayList<>();

        for(int i = 0; i < listBanco.size(); i++){
            listDTO.add(toVendaDto(listBanco.get(i)));
        }

        return listDTO;
    }

    public VendaDTO findById(Long id){
        Venda vendaBanco = this.vendaRepository.findById(id).orElse(null);

        Assert.isTrue(vendaBanco != null, "Venda Inválido");

        return toVendaDto(vendaBanco);
    }

    public void criar(VendaDTO vendaDTO){
        venda = toVenda(vendaDTO);

        this.vendaRepository.save(venda);
    }

    public void editar(VendaDTO vendaDTO, Long id){
        venda = this.vendaRepository.findById(id).orElse(null);

        Assert.isTrue(venda != null, "Venda Inválida");

        Assert.isTrue(vendaDTO != null, "Venda Inválida");

        venda.setIdFuncionario(vendaDTO.getIdFuncionario());
        venda.setIdPedido(vendaDTO.getIdPedido());
        venda.setTipoEntrega(vendaDTO.getTipoEntrega());
        venda.setTipoPagamento(vendaDTO.getTipoPagamento());

        this.vendaRepository.save(venda);
    }

    public void deletar(Long id){
        venda = this.vendaRepository.findById(id).orElse(null);

        Assert.isTrue(venda != null, "Venda Inválido ");

        this.vendaRepository.delete(venda);
    }

    public VendaDTO toVendaDto(Venda venda){
        vendaDTO = new VendaDTO();
        vendaDTO.setIdVenda(venda.getIdVenda());
        vendaDTO.setIdFuncionario(venda.getIdFuncionario());
        vendaDTO.setIdPedido(venda.getIdPedido());
        vendaDTO.setTipoEntrega(venda.getTipoEntrega());
        vendaDTO.setTipoPagamento(venda.getTipoPagamento());

        return vendaDTO;
    }

    public Venda toVenda(VendaDTO vendaDTO){
        venda = new Venda();
        venda.setIdFuncionario(vendaDTO.getIdFuncionario());
        venda.setIdPedido(vendaDTO.getIdPedido());
        venda.setTipoEntrega(vendaDTO.getTipoEntrega());
        venda.setTipoPagamento(vendaDTO.getTipoPagamento());

        return venda;
    }
}
