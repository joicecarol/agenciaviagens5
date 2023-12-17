package com.agenciaviagens.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agenciaviagens.models.ViagensClientesDTO;
import com.agenciaviagens.services.ViagensService;

@RestController
@RequestMapping("/viagensrelcliente")
public class ViagensClienteController {

	
	
	@Autowired
	private ViagensService cs;
	
	
	
	@PostMapping("/addviagenscliente")
	public ResponseEntity<String> addRelationship(@RequestBody ViagensClientesDTO csDTO){
		cs.addRelationship(csDTO.getViagensId(), csDTO.getClienteId());
		
		
		return new ResponseEntity<>("Relatioship created", HttpStatus.CREATED);
		
		
	}
	
	
	
	
	
	
	
	
	
}
