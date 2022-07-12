package br.com.gas.telemetria.controller.form;

import br.com.gas.telemetria.models.Cliente;
import br.com.gas.telemetria.repository.ClienteRepository;

public class AtualizacaoCliente {
	
	private String nomeCliente;
	private String endereco;
	private String numero;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}

	public Cliente atualizar(Long id, ClienteRepository clienteRepository) {
		
		Cliente clientes = clienteRepository.getReferenceById(id);
		if(nomeCliente != null) {
			clientes.setNomeCliente(this.nomeCliente);
			}
		if(endereco != null) {
			clientes.setEndereco(this.endereco);
		}
		if(numero != null) {
			clientes.setNumero(this.numero);
		}
		if(bairro != null) {
			clientes.setBairro(this.bairro);
		}
		if(cidade != null) {
			clientes.setCidade(this.cidade);
		}
		if(uf != null) {
			clientes.setUf(this.uf);
		}
		if(cep != null) {
			clientes.setCep(this.cep);
		}
		
		return clientes;
	}

}

