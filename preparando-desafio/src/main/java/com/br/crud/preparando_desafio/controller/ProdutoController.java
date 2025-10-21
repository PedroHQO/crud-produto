package com.br.crud.preparando_desafio.controller;

import com.br.crud.preparando_desafio.entidade.Produto;
import com.br.crud.preparando_desafio.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> criar(@RequestBody Produto produto){
        Produto novoProduto = produtoService.create(produto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(novoProduto.getId()).toUri();
        return ResponseEntity.created(location).body(novoProduto);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> findAll(){
        return ResponseEntity.ok(produtoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id){
        Optional<Produto> produto = produtoService.findById(id);

        if(produto.isPresent()){
            return ResponseEntity.ok(produto.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@RequestBody Produto produto, @PathVariable Long id){
        Produto novoProduto = produtoService.update(produto, id);

        if(produto != null){
            return ResponseEntity.ok(novoProduto);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        boolean deletado = produtoService.delete(id);
        if(deletado){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
