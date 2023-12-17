package com.agenciaviagens.servicesmpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.agenciaviagens.models.Cliente;

import com.agenciaviagens.repositories.ClienteRepository;
import com.agenciaviagens.services.ClienteServices;

@Service
public class ClienteServiceslpml implements ClienteServices {

	@Autowired
	private ClienteRepository sr;

	@Override
	public List<Cliente> getAllClientes() {

		return sr.findAll();
	}

	@Override
	public Cliente getClienteById(Long id) {

		return sr.findById(id).orElseThrow(() -> new RuntimeException("ID: " + id + "Not Found"));
	}

	@Override
	public Cliente saveCliente(Cliente cliente) {

		return sr.save(cliente);
	}

	@Override
	public Cliente updateCliente(Long id, Cliente clienteUpdated) {
		Cliente clienteExists = sr.findById(id).orElseThrow(() -> new RuntimeException("ID: " + id + "Not Found"));
		clienteExists.setName(clienteUpdated.getName());
		clienteExists.setTelefone(clienteUpdated.getTelefone());
        clienteExists.setEmail(clienteUpdated.getEmail());

		return sr.save(clienteExists);
	}

	@Override
	public void deleteById(Long id) {
		sr.deleteById(id);

	}

}
