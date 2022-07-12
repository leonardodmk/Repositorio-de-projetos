package br.com.gas.telemetria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gas.telemetria.models.Instalacao;

public interface InstalacaoRepository extends JpaRepository<Instalacao, Long>{
	
	List<Instalacao> findByCliente_Cep(String cep);

}
