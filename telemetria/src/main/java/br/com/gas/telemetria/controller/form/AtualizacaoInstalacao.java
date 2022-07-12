package br.com.gas.telemetria.controller.form;

import java.time.LocalDateTime;

import br.com.gas.telemetria.models.Cliente;
import br.com.gas.telemetria.models.Equipamento;
import br.com.gas.telemetria.models.Instalacao;
import br.com.gas.telemetria.repository.InstalacaoRepository;

public class AtualizacaoInstalacao {
	
	private Cliente cliente;
	private Equipamento equipamento; 
	private LocalDateTime dataInstalacao;
	private String status;
	
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Equipamento getEquipamento() {
		return equipamento;
	}
	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	public LocalDateTime getDataInstalacao() {
		return dataInstalacao;
	}
	public void setDataInstalacao(LocalDateTime dataInstalacao) {
		this.dataInstalacao = dataInstalacao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
public Instalacao atualizarInstalacao(Long id, InstalacaoRepository instalacaoRepository) {
		
		Instalacao instalacao = instalacaoRepository.getReferenceById(id);
		if(cliente != null) {
			instalacao.setCliente(this.cliente);
			}
		if(equipamento != null) {
			instalacao.setEquipamento(this.equipamento);
		}
		if(dataInstalacao != null) {
			instalacao.setDataInstalacao(this.dataInstalacao);
		}
		if(status != null) {
			instalacao.setStatus(this.status);
		}
		
		
		return instalacao;
	}

}
