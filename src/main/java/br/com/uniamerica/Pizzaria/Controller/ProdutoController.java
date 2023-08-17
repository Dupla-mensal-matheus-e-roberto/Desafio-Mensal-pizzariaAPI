package br.com.uniamerica.Pizzaria.Controller;

import br.com.uniamerica.Pizzaria.DTO.ProdutoDTO;
import br.com.uniamerica.Pizzaria.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/produto")
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
    public ResponseEntity<String> criar(@RequestBody ProdutoDTO produtoDTO){
        try{
            this.produtoService.criar(produtoDTO);
            return ResponseEntity.ok("Produto cadastrado com sucesso");
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editar(@RequestBody ProdutoDTO produtoDTO, @PathVariable("id") Long id){
        try{
            this.produtoService.editar(produtoDTO, id);
            return ResponseEntity.ok("Produto editado com sucesso");
        } catch(Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/deeltar/{id}")
    public ResponseEntity<String> deletar(@PathVariable("id") Long id){
        try{
            this.produtoService.deletar(id);
            return ResponseEntity.ok("Produto deletado com sucesso");
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
