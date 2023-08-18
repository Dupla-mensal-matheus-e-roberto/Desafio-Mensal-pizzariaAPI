package br.com.uniamerica.Pizzaria.Service;

import br.com.uniamerica.Pizzaria.DTO.PedidoDTO;
import br.com.uniamerica.Pizzaria.Entity.Pedido;
import br.com.uniamerica.Pizzaria.Repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    private Pedido pedido;
    private PedidoDTO pedidoDTO;

    public List<PedidoDTO> getAll(){
        List<Pedido> listBanco = this.pedidoRepository.findAll();
        List<PedidoDTO> listDTO = new ArrayList<>();

        for(int i = 0; i < listBanco.size(); i++){
            listDTO.add(toPedidoDto(listBanco.get(i)));
        }

        return listDTO;
    }

    public PedidoDTO findById(Long id){
        Pedido pedidoBanco = this.pedidoRepository.findById(id).orElse(null);

        Assert.isTrue(pedidoBanco != null, "Pedido Inválido");

        return toPedidoDto(pedidoBanco);
    }
    public void criar(PedidoDTO pedidoDTO){
        pedido = toPedido(pedidoDTO);

        this.pedidoRepository.save(pedido);
    }

    public void editar(PedidoDTO pedidoDTO, Long id){
        pedido = this.pedidoRepository.findById(id).orElse(null);

        Assert.isTrue(pedido != null, "Pedido Inválido");

        Assert.isTrue(pedidoDTO != null, "Pedido Inválido");

        pedido.setDataDoPedido(pedidoDTO.getDataDoPedido());
        pedido.setStatus(pedidoDTO.getStatus());
        pedido.setIdProduto(pedidoDTO.getIdProduto());
        pedido.setIdCliente(pedidoDTO.getIdCliente());

        this.pedidoRepository.save(pedido);
    }

    public void deletar(Long id){
        pedido = this.pedidoRepository.findById(id).orElse(null);

        Assert.isTrue(pedido != null, "Pedido Inválido");

        this.pedidoRepository.delete(pedido);
    }

    public PedidoDTO toPedidoDto(Pedido pedido){
        pedidoDTO = new PedidoDTO();
        pedidoDTO.setIdCliente(pedido.getIdCliente());
        pedidoDTO.setDataDoPedido(pedido.getDataDoPedido());
        pedidoDTO.setStatus(pedido.getStatus());
        pedidoDTO.setIdProduto(pedido.getIdProduto());
        pedidoDTO.setIdCliente(pedido.getIdCliente());

        return pedidoDTO;
    }

    public Pedido toPedido(PedidoDTO pedidoDTO){
        pedido = new Pedido();
        pedido.setDataDoPedido(LocalDateTime.now());
        pedido.setStatus(pedidoDTO.getStatus());
        pedido.setIdProduto(pedidoDTO.getIdProduto());
        pedido.setIdCliente(pedidoDTO.getIdCliente());

        return pedido;
    }
}
