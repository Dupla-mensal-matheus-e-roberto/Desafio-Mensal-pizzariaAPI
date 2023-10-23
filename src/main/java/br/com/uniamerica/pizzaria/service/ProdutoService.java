package br.com.uniamerica.pizzaria.service;

import br.com.uniamerica.pizzaria.dto.PedidoDTO;
import br.com.uniamerica.pizzaria.dto.PizzaDTO;
import br.com.uniamerica.pizzaria.dto.ProdutoDTO;
import br.com.uniamerica.pizzaria.entity.Pedido;
import br.com.uniamerica.pizzaria.entity.Pizza;
import br.com.uniamerica.pizzaria.entity.Produto;
import br.com.uniamerica.pizzaria.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    private Produto produto;
    @Autowired
    private PizzaService pizzaService;

    public List<ProdutoDTO> getAll(){
        List<Produto> listBanco = this.produtoRepository.findAll();
        List<ProdutoDTO> listDTO = new ArrayList<>();

        for(int i = 0; i < listBanco.size(); i++){
            listDTO.add(toProdutoDto(listBanco.get(i)));
        }

        return listDTO;
    }

    public ProdutoDTO findById(Long id){
        Produto produtoBanco = this.produtoRepository.findById(id).orElse(null);

        return toProdutoDto(produtoBanco);
    }

    public ProdutoDTO criar(ProdutoDTO produtoDTO){
        produto = toProduto(produtoDTO);

        this.produtoRepository.save(produto);
        return produtoDTO;
    }

    public ProdutoDTO editar(ProdutoDTO produtoDTO, Long id){
        produto = this.produtoRepository.findById(id).orElse(null);

        Assert.isTrue( produto != null, "Produto Inválido");

        produto = toProduto(produtoDTO);

        Produto produto1 = this.produtoRepository.save(produto);

        return toProdutoDto(produto1);
    }

    public void deletar(Long id){
        produto = this.produtoRepository.findById(id).orElse(null);

        Assert.isTrue( produto != null, "Produto Inválido");

        this.produtoRepository.delete(produto);
    }

    public ProdutoDTO toProdutoDto(Produto produto){
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setIdProduto(produto.getIdProduto());
        produtoDTO.setAcompanhamentos(produto.getAcompanhamentos());
        produtoDTO.setPreco(produto.getPreco());
        List<PizzaDTO> listaTmpPizza = new ArrayList<>();

        if (produto.getPizzas() != null)
            for (int i=0; i< produto.getPizzas().size(); i++){
                listaTmpPizza.add(pizzaService.toPizzaDto(produto.getPizzas().get(i)));
            }

        produtoDTO.setPizzas(listaTmpPizza);

        return produtoDTO;
    }
    public Produto toProduto(ProdutoDTO produtoDTO){
        produto = new Produto();
        produto.setIdProduto(produtoDTO.getIdProduto());
        produto.setAcompanhamentos(produtoDTO.getAcompanhamentos());
        produto.setPreco(produtoDTO.getPreco());
        List<Pizza> listaTmpPizza = new ArrayList<>();
        if (produtoDTO.getPizzas() != null)
            for(int i =0; i< produtoDTO.getPizzas().size(); i++){
                listaTmpPizza.add(pizzaService.toPizza(produtoDTO.getPizzas().get(i)));
            }

        produto.setPizzas(listaTmpPizza);


        return produto;
    }
}
