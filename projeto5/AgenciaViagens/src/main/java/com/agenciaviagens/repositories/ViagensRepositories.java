package com.agenciaviagens.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.agenciaviagens.models.Viagens;

import jakarta.transaction.Transactional;

@Repository
public interface ViagensRepositories extends JpaRepository<Viagens, Long>{

	
	@Transactional
	@Modifying
	@Query(nativeQuery= true, value= "INSERT INTO viagens_cliente (viagens_id, cliente_id) VALUES (:viagensId, :clienteId)")
	void addRelationship(@Param("viagensId") Long viagensId, @Param("clienteId") Long clienteId);
	
	
	
	
}
