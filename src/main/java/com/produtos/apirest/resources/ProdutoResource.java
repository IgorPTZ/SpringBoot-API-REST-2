
package com.produtos.apirest.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

@RestController
@RequestMapping(value="/api")
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	public List<Produto> listar() {
		
		return produtoRepository.findAll();
	}
	
	@GetMapping("/produto/{id}")
	public Produto obter(@PathVariable(value="id") Long id) {
		
		  Optional<Produto> produto = produtoRepository.findById(id); 
		  return produto.get();
	}
	
	@PostMapping("/produto")
	public Produto salvar(@RequestBody Produto produto) {
		
		return produtoRepository.save(produto);
	}
	
	@DeleteMapping("/produto")
	public void excluir(@RequestBody Produto produto) {
		
		produtoRepository.delete(produto);
	}
	
	@PutMapping("/produto")
	public Produto modificar(@RequestBody Produto produto) {
		
		return produtoRepository.save(produto); 
	}
}
