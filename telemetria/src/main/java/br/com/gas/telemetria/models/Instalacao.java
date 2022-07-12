
package br.com.gas.telemetria.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Instalacao {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(optional = false)
	@JoinColumn(name = "CODIGO_CLIENTE", nullable = false)
	private Cliente cliente;
	@ManyToOne(optional = false)
	@JoinColumn(name = "CODIGO_EQUIPAMENTO", nullable = false)
	private Equipamento equipamento; 
	private LocalDateTime dataInstalacao;
	private String status;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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

}
