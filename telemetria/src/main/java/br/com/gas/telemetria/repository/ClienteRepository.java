package br.com.gas.telemetria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gas.telemetria.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	List<Cliente> findByCep(String cep);
	
}
