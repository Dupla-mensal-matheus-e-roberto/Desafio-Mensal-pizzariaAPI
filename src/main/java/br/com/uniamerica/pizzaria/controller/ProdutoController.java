package br.com.uniamerica.pizzaria.controller;

import br.com.uniamerica.pizzaria.dto.ProdutoDTO;
import br.com.uniamerica.pizzaria.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/all")
    public ResponseEntity<List<ProdutoDTO>> getAll(){
        try{
            return ResponseEntity.ok(this.produtoService.getAll());
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<ProdutoDTO> findById(@PathVariable("id") Long id){
        try{
            return ResponseEntity.ok(this.produtoService.findById(id));
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<ProdutoDTO> criar(@RequestBody ProdutoDTO produtoDTO){
        try{
            System.out.println("aaaa");
            return ResponseEntity.ok(this.produtoService.criar(produtoDTO));
        } catch (Exception e){
            System.out.println(e.getMessage());

            System.out.println("bbbbb");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<ProdutoDTO> editar(@RequestBody ProdutoDTO produtoDTO, @PathVariable("id") Long id){
        try{

            return ResponseEntity.ok(this.produtoService.editar(produtoDTO, id));
        } catch(Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable("id") Long id){
        try{
            this.produtoService.deletar(id);
            return ResponseEntity.ok("Produto deletado com sucesso");
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
