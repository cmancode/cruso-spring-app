package com.cmancode.app.service;

import java.util.List;

import com.cmancode.app.model.Cliente;

public interface IClienteService {
	
	public void saveClient (Cliente cliente);
	public void updateClient (Cliente cliente);
	public Cliente findCliente (Long id);
	public List<Cliente> findAllClient ();

}
