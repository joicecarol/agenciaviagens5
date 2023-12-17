package com.agenciaviagens.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agenciaviagens.models.Viagens;
import com.agenciaviagens.services.ViagensService;

@RestController
@RequestMapping("/viagens")
public class ViagensController {

	@Autowired
	private ViagensService cs;

	@PostMapping("/saveviagens")
	public Viagens createViagens(@RequestBody Viagens viagens) {

		return cs.saveViagens(viagens);
	}

	@GetMapping("/allviagens")
	public List<Viagens> getAllViagens() {

		return cs.getAllViagens();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Viagens> getViagensById(@PathVariable Long id){
		Viagens viagens = cs.getViagensById(id);
		
		return ResponseEntity.ok(viagens);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Viagens> updateViagens(@PathVariable Long id, @RequestBody Viagens viagensUpdated){
		Viagens viagens = cs.getViagensById(id);
		
		viagens.setName(viagensUpdated.getName());
		
		viagens.setDataPartida(viagensUpdated.getDataPartida());
        viagens.setDataRetorno(viagensUpdated.getDataRetorno());
        viagens.setQuantidadePessoas(viagensUpdated.getQuantidadePessoas());
		
		
		cs.saveViagens(viagens);
		
		
		return ResponseEntity.ok(viagens);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteViagens(@PathVariable Long id) {
		cs.deleteById(id);
	}
	
	

}
