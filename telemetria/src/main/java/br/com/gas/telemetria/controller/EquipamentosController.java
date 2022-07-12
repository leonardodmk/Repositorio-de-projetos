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

import br.com.gas.telemetria.controller.form.AtualizacaoEquipamento;
import br.com.gas.telemetria.models.Equipamento;
import br.com.gas.telemetria.repository.EquipamentoRepository;


@RestController
@RequestMapping("/equipamentos")
public class EquipamentosController {
	
	@Autowired
	private EquipamentoRepository equipamentoRepository;
	
	@GetMapping
	public List<Equipamento> listar(String numeroSerieEquipamento){
		if (numeroSerieEquipamento == null) {
			List<Equipamento> equipamentos = equipamentoRepository.findAll();
			return equipamentos; 
		}else{
			List<Equipamento> equipamentos = equipamentoRepository.findByNumeroSerieEquipamento(numeroSerieEquipamento);
			return equipamentos;
		}
	}
	
	@GetMapping("/{codigoEquipamento}") 
	public ResponseEntity<Equipamento> listarPorId(@PathVariable Long codigoEquipamento) {
		Optional<Equipamento> equipamentos = equipamentoRepository.findById(codigoEquipamento);
		if(equipamentos.isPresent()) {
			return ResponseEntity.ok(equipamentos.get());
		}
		return ResponseEntity.badRequest().build();
		}

	@PostMapping
	@Transactional
	public ResponseEntity<Equipamento> cadastrar(@RequestBody @Valid Equipamento equipamentos, UriComponentsBuilder uriBuilder) {
		equipamentoRepository.save(equipamentos);
	    URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(equipamentos.getCodigoEquipamento()).toUri();
	    return ResponseEntity.created(uri).body(equipamentos);
	}
	
	@PutMapping("/alterar/{id}")
	@Transactional
	public ResponseEntity<Equipamento> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoEquipamento form){
		Optional<Equipamento> opcional = equipamentoRepository.findById(id);
		if(opcional.isPresent()) {
			Equipamento equipamentos = form.atualizarEquipamento(id, equipamentoRepository);
			return ResponseEntity.ok(equipamentos);
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		Optional<Equipamento> opcional = equipamentoRepository.findById(id);
		if(opcional.isPresent()) {
			equipamentoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
}


	

