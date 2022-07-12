package br.com.gas.telemetria.controller.form;

import br.com.gas.telemetria.models.Equipamento;
import br.com.gas.telemetria.repository.EquipamentoRepository;

public class AtualizacaoEquipamento {
	
	private String nomeEquipamento;
	private String quantidadeSensores;
	private String numeroSerieEquipamento;
	private String fabricante;
	
	
	public String getNomeEquipamento() {
		return nomeEquipamento;
	}
	public void setNomeEquipamento(String nomeEquipamento) {
		this.nomeEquipamento = nomeEquipamento;
	}
	public String getQuantidadeSensores() {
		return quantidadeSensores;
	}
	public void setQuantidadeSensores(String quantidadeSensores) {
		this.quantidadeSensores = quantidadeSensores;
	}
	public String getNumeroSerieEquipamento() {
		return numeroSerieEquipamento;
	}
	public void setNumeroSerieEquipamento(String numeroSerieEquipamento) {
		this.numeroSerieEquipamento = numeroSerieEquipamento;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	
public Equipamento atualizarEquipamento(Long id, EquipamentoRepository equipamentoRepository) {
		
		Equipamento equipamentos = equipamentoRepository.getReferenceById(id);
		if(nomeEquipamento != null) {
			equipamentos.setNomeEquipamento(this.nomeEquipamento);
			}
		if(quantidadeSensores != null) {
			equipamentos.setQuantidadeSensores(this.quantidadeSensores);
		}
		if(numeroSerieEquipamento != null) {
			equipamentos.setNumeroSerieEquipamento(this.numeroSerieEquipamento);
		}
		if(fabricante != null) {
			equipamentos.setFabricante(this.fabricante);
		}
		
		
		return equipamentos;
	}
	
}
