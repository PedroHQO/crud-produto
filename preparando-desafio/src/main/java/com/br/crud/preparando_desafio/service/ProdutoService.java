package com.br.crud.preparando_desafio.service;

import com.br.crud.preparando_desafio.entidade.Produto;
import com.br.crud.preparando_desafio.repository.IProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private IProdutoRepository repository;

    public Produto create(Produto produto){
        return repository.save(produto);
    }

    public List<Produto> findAll(){
        return repository.findAll();
    }

    public Optional<Produto> findById(Long id){
        return repository.findById(id);
    }

    public Produto update(Produto produto, Long id){
        if(!repository.existsById(id)){
            return null;
        }
        produto.setId(id);
        return repository.save(produto);
    }

    public boolean delete(Long id){
        if(!repository.existsById(id)){
            return false;
        }
        repository.deleteById(id);
        return true;
    }

}
