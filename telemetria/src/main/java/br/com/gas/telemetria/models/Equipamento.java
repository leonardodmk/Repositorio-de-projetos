package br.com.gas.telemetria.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Equipamento {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoEquipamento;
	@NotNull @NotEmpty 
	private String nomeEquipamento;
	@NotNull @NotEmpty 
	private String quantidadeSensores;
	@NotNull @NotEmpty
	private String numeroSerieEquipamento;
	@NotNull @NotEmpty 
	private String fabricante;
	
	@Override
	public int hashCode() {
		return Objects.hash(codigoEquipamento);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipamento other = (Equipamento) obj;
		return Objects.equals(codigoEquipamento, other.codigoEquipamento);
	}
	
	public Long getCodigoEquipamento() {
		return codigoEquipamento;
	}
	public void setCodigoEquipamento(Long codigoEquipamento) {
		this.codigoEquipamento = codigoEquipamento;
	}
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

}
