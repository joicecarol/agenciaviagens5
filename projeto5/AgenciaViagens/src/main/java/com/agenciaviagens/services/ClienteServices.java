package com.agenciaviagens.services;

import java.util.List;

import com.agenciaviagens.models.Cliente;


public interface ClienteServices  {

	
	
	List<Cliente> getAllClientes();
	
	Cliente getClienteById(Long id);
	
	Cliente saveCliente(Cliente cliente);
	
	Cliente updateCliente(Long id, Cliente clienteUpdated);
	
	void deleteById(Long id);
	
	
	
	
	
	
	
}