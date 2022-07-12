package br.com.gas.telemetria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gas.telemetria.models.Equipamento;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long>{
	
	List<Equipamento> findByNumeroSerieEquipamento(String numeroSerieEquipamento);

}
