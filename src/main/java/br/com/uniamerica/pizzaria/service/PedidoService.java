package br.com.uniamerica.pizzaria.service;

import br.com.uniamerica.pizzaria.dto.PedidoDTO;
import br.com.uniamerica.pizzaria.dto.PizzaDTO;
import br.com.uniamerica.pizzaria.dto.ProdutoDTO;
import br.com.uniamerica.pizzaria.entity.Pedido;
import br.com.uniamerica.pizzaria.entity.Pizza;
import br.com.uniamerica.pizzaria.entity.Produto;
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
    @Autowired
    private PizzaService pizzaService;

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

        pedido = toPedido(pedidoDTO);

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


        List<ProdutoDTO> listaTmp = new ArrayList<>();

        if (pedido.getProdutos() != null)
            for (int i = 0; i< pedido.getProdutos().size(); i++){
                listaTmp.add(toProdutoDto(pedido.getProdutos().get(i)));
            }

        pedidoDTO.setProdutos(listaTmp);


        return pedidoDTO;
    }

    public Pedido toPedido(PedidoDTO pedidoDTO){
        pedido = new Pedido();
        pedido.setIdPedido(pedidoDTO.getIdPedido());
        pedido.setDataDoPedido(pedidoDTO.getDataDoPedido());
        pedido.setStatus(pedidoDTO.getStatus());
        pedido.setCliente(pedidoDTO.getCliente());

        List<Produto> listaTmpProduto = new ArrayList<>();

        if (pedidoDTO.getProdutos() != null)
            for(int i = 0; i< pedidoDTO.getProdutos().size(); i++){
                listaTmpProduto.add(toProduto(pedidoDTO.getProdutos().get(i)));
            }

        pedido.setProdutos(listaTmpProduto);


        return pedido;
    }

    public ProdutoDTO toProdutoDto(Produto produto){
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setIdProduto(produto.getIdProduto());
        produtoDTO.setAcompanhamentos(produto.getAcompanhamentos());
        produtoDTO.setPreco(produto.getPreco());
        List<PizzaDTO> listaTmpPizza = new ArrayList<>();

        for (int i=0; i< produto.getPizzas().size(); i++){
            listaTmpPizza.add(pizzaService.toPizzaDto(produto.getPizzas().get(i)));
        }

        produtoDTO.setPizzas(listaTmpPizza);
        
        return produtoDTO;
    }
    public Produto toProduto(ProdutoDTO produtoDTO){
        Produto produto = new Produto();
        produto.setIdProduto(produtoDTO.getIdProduto());
        produto.setAcompanhamentos(produtoDTO.getAcompanhamentos());
        produto.setPreco(produtoDTO.getPreco());
        List<Pizza> listaTmpPizza = new ArrayList<>();

        for(int i =0; i< produtoDTO.getPizzas().size(); i++){
            listaTmpPizza.add(pizzaService.toPizza(produtoDTO.getPizzas().get(i)));
        }

        produto.setPizzas(listaTmpPizza);

        return produto;
    }
}
