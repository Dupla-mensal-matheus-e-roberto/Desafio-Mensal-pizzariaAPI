package br.com.uniamerica.pizzaria.service;

import br.com.uniamerica.pizzaria.dto.PedidoDTO;
import br.com.uniamerica.pizzaria.entity.Pedido;
import br.com.uniamerica.pizzaria.repository.PedidoRepository;
import org.hibernate.type.descriptor.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    private Pedido pedido;
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

        return toPedidoDto(pedidoBanco);
    }
    public PedidoDTO criar(PedidoDTO pedidoDTO){
        pedido = toPedido(pedidoDTO);

        LocalDateTime dateAtual = LocalDateTime.now();

        DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        pedido.setDataDoPedido(dateAtual.format(dataFormat));

        Pedido pedido1 = this.pedidoRepository.save(pedido);

        return toPedidoDto(pedido1);
    }

    public PedidoDTO editar(PedidoDTO pedidoDTO, Long id){
        pedido = this.pedidoRepository.findById(id).orElse(null);

        Assert.isTrue(pedido != null, "Pedido Inválido");

        pedido.setDataDoPedido(pedidoDTO.getDataDoPedido());
        pedido.setStatus(pedidoDTO.getStatus());
        pedido.setProdutos(pedidoDTO.getProdutos());
        pedido.setCliente(pedidoDTO.getCliente());

        Pedido pedido1 = this.pedidoRepository.save(pedido);

        return toPedidoDto(pedido1);
    }

    public String deletar(Long id){
        pedido = this.pedidoRepository.findById(id).orElse(null);

        Assert.isTrue(pedido != null, "Pedido Inválido");

        this.pedidoRepository.delete(pedido);

        return "Pedido deletado com sucesso";
    }

    public PedidoDTO toPedidoDto(Pedido pedido){
        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setIdPedido(pedido.getIdPedido());
        pedidoDTO.setCliente(pedido.getCliente());
        pedidoDTO.setDataDoPedido(pedido.getDataDoPedido());
        pedidoDTO.setStatus(pedido.getStatus());
        pedidoDTO.setProdutos(pedido.getProdutos());
        pedidoDTO.setVendas(pedido.getVendas());
        return pedidoDTO;
    }

    public Pedido toPedido(PedidoDTO pedidoDTO){
        pedido = new Pedido();
        pedido.setIdPedido(pedidoDTO.getIdPedido());
        pedido.setDataDoPedido(pedidoDTO.getDataDoPedido());
        pedido.setStatus(pedidoDTO.getStatus());
        pedido.setProdutos(pedidoDTO.getProdutos());
        pedido.setCliente(pedidoDTO.getCliente());
        pedido.setVendas(pedidoDTO.getVendas());
        return pedido;
    }
}
