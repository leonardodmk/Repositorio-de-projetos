package br.com.gas.telemetria.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.gas.telemetria.controller.form.AtualizacaoCliente;
import br.com.gas.telemetria.models.Cliente;
import br.com.gas.telemetria.repository.ClienteRepository;


@RestController
@RequestMapping("/clientes")
public class ClientesController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	@GetMapping
	public List<Cliente> listar(String cep){
		if (cep == null) {
			List<Cliente> clientes = clienteRepository.findAll();
			return clientes; 
		}else{
			List<Cliente> clientes = clienteRepository.findByCep(cep);
			return clientes;
		}
	}
	
	@GetMapping("/{id}") 
	public ResponseEntity<Cliente> listarPorId(@PathVariable Long id) {
		Optional<Cliente> clientes = clienteRepository.findById(id);
		if(clientes.isPresent()) {
			return ResponseEntity.ok(clientes.get());
		}
		return ResponseEntity.badRequest().build();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<Cliente> cadastrar(@RequestBody @Valid Cliente clientes, UriComponentsBuilder uriBuilder) {
	    clienteRepository.save(clientes);
	    URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(clientes.getCodigoCliente()).toUri();
	    return ResponseEntity.created(uri).body(clientes);
	}
	
	@PutMapping("/alterar/{id}")
	@Transactional
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoCliente form){
		Optional<Cliente> opcional = clienteRepository.findById(id);
		if(opcional.isPresent()) {
			Cliente clientes = form.atualizar(id, clienteRepository);
			return ResponseEntity.ok(clientes);
		}
		return ResponseEntity.notFound().build();
	}
	
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		Optional<Cliente> opcional = clienteRepository.findById(id);
		if(opcional.isPresent()) {
			clienteRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	
}
