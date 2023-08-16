package br.com.uniamerica.Pizzaria.Controller;

import br.com.uniamerica.Pizzaria.DTO.PedidoDTO;
import br.com.uniamerica.Pizzaria.Service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/all")
    public ResponseEntity<List<PedidoDTO>> getAll(){
        try{
            return ResponseEntity.ok(this.pedidoService.getAll());
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<PedidoDTO> findById(@PathVariable("id") Long id){
        try{
            return ResponseEntity.ok(this.pedidoService.findById(id));
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criar(@RequestBody PedidoDTO pedidoDTO){
        try{
            this.pedidoService.criar(pedidoDTO);
            return ResponseEntity.ok("Pedido cadastrado com sucesso");
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editar(@RequestBody PedidoDTO pedidoDTO, @PathVariable("id") Long id){
        try{
            this.pedidoService.editar(pedidoDTO, id);
            return ResponseEntity.ok("Pedido editado com sucesso");
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable("id") Long id){
        try{
            this.pedidoService.deletar(id);
            return ResponseEntity.ok("Pedido deletado com sucesso");
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }

}
