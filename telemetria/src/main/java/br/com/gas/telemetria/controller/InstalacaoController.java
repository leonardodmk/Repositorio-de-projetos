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

import br.com.gas.telemetria.controller.form.AtualizacaoInstalacao;
import br.com.gas.telemetria.models.Instalacao;
import br.com.gas.telemetria.repository.InstalacaoRepository;

@RestController
@RequestMapping("/instalacoes")
public class InstalacaoController {
	
	@Autowired
	private InstalacaoRepository instalacaoRepository;
	
	@GetMapping
	public List<Instalacao> listar(String cep){
		if (cep == null) {
			List<Instalacao> instalacao = instalacaoRepository.findAll();
			return instalacao; 
		}else{
			List<Instalacao> instalacao = instalacaoRepository.findByCliente_Cep(cep);
			return instalacao;
		}
	}
	
	@GetMapping("/{id}") 
	public ResponseEntity<Instalacao> listarPorId(@PathVariable Long id) {
		Optional<Instalacao> instalacao = instalacaoRepository.findById(id);
		if(instalacao.isPresent()) {
			return ResponseEntity.ok(instalacao.get());
		}
		return ResponseEntity.badRequest().build();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<Instalacao> cadastrar(@RequestBody @Valid Instalacao instalacao, UriComponentsBuilder uriBuilder) {
		instalacaoRepository.save(instalacao);
	    URI uri = uriBuilder.path("/instalacao/{id}").buildAndExpand(instalacao.getId()).toUri();
	    return ResponseEntity.created(uri).body(instalacao);
	}
	
	@PutMapping("/alterar/{id}")
	@Transactional
	public ResponseEntity<Instalacao> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoInstalacao form){
		Optional<Instalacao> opcional = instalacaoRepository.findById(id);
		if(opcional.isPresent()) {
			Instalacao instalacao = form.atualizarInstalacao(id, instalacaoRepository);
			return ResponseEntity.ok(instalacao);
		}
		return ResponseEntity.notFound().build(); 
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		Optional<Instalacao> opcional = instalacaoRepository.findById(id);
		if(opcional.isPresent()) {
			instalacaoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}



}
