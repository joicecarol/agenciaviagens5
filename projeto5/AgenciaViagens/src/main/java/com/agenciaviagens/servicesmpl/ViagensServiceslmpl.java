package com.agenciaviagens.servicesmpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenciaviagens.models.Viagens;
import com.agenciaviagens.models.Cliente;
import com.agenciaviagens.repositories.ViagensRepositories;
import com.agenciaviagens.repositories.ClienteRepository;
import com.agenciaviagens.services.ViagensService;

@Service
public class ViagensServiceslmpl implements ViagensService {

	@Autowired
	private ViagensRepositories cr;
	
	@Autowired
	private ClienteRepository sr;

	@Override
	public List<Viagens> getAllViagens() {

		return cr.findAll();
	}

	@Override
	public Viagens getViagensById(Long id) {

		return cr.findById(id).orElseThrow(() -> new RuntimeException("ID: " + id + "Not Found"));
	}

	@Override
	public Viagens saveViagens(Viagens viagens) {
		
		return cr.save(viagens);
	}

	@Override
	public Viagens updateViagens(Long id, Viagens viagensUpdated) {
		Viagens viagensExists = cr.findById(id).orElseThrow(() -> new RuntimeException("ID: " + id + "Not Found"));
	viagensExists.setName(viagensUpdated.getName());
	
	viagensExists.setDataPartida(viagensUpdated.getDataPartida());
    viagensExists.setDataRetorno(viagensUpdated.getDataRetorno());
    viagensExists.setQuantidadePessoas(viagensUpdated.getQuantidadePessoas());
    
	
		
		
		
		return cr.save(viagensExists);
	}

	@Override
	public void deleteById(Long id) {
		cr.deleteById(id);

	}

	@Override
	public void addRelationship(Long viagensId, Long clienteId) {
		Viagens viagens = cr.findById(viagensId).orElseThrow(() -> new RuntimeException("ID: " + viagensId + "Not Found"));
		Cliente cliente = sr.findById(clienteId).orElseThrow(() -> new RuntimeException("ID: " + clienteId + "Not Found"));
		
		if(viagens != null && cliente != null) {
			viagens.getClientes().add(cliente);
			cliente.getViagens().add(viagens);
			
			cr.save(viagens);
			sr.save(cliente);
		}
		
		
		
	}

	
}