package br.com.uniamerica.pizzaria.service;

import br.com.uniamerica.pizzaria.dto.ProdutoDTO;
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

    public void criar(ProdutoDTO produtoDTO){
        produto = toProduto(produtoDTO);

        this.produtoRepository.save(produto);
    }

    public void editar(ProdutoDTO produtoDTO, Long id){
        produto = this.produtoRepository.findById(id).orElse(null);

        Assert.isTrue( produto != null, "Produto Inválido");

        produto.setAcompanhamentos(produtoDTO.getAcompanhamentos());
        produto.setPizza(produtoDTO.getPizza());

        this.produtoRepository.save(produto);
    }

    public void deletar(Long id){
        produto = this.produtoRepository.findById(id).orElse(null);

        Assert.isTrue( produto != null, "Produto Inválido");

        this.produtoRepository.delete(produto);
    }

    public ProdutoDTO toProdutoDto(Produto produto){
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setIdProduto(produto.getIdProduto());
        produtoDTO.setPizza(produto.getPizza());
        produtoDTO.setAcompanhamentos(produto.getAcompanhamentos());

        return produtoDTO;
    }
    public Produto toProduto(ProdutoDTO produtoDTO){
        produto = new Produto();
        produto.setPizza(produtoDTO.getPizza());
        produto.setAcompanhamentos(produtoDTO.getAcompanhamentos());

        return produto;
    }
}
