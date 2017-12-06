package com.cmancode.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmancode.app.dao.IClienteDao;
import com.cmancode.app.exeptions.InstanceNotFoundException;
import com.cmancode.app.model.Cliente;

@Service("clienteService")
@Transactional
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteDao clienteDao;
	
	@Override
	@Transactional
	public void saveClient(Cliente cliente) {
		clienteDao.save(cliente);		
	}

	@Override
	@Transactional
	public void updateClient(Cliente cliente) {
		clienteDao.save(cliente);		
	}

	@Override
	@Transactional
	public Cliente findCliente(Long id) {
		Cliente cliente = null;
		try {
			cliente = clienteDao.find(id);
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cliente;
	}

	@Override
	@Transactional
	public List<Cliente> findAllClient() {
		List<Cliente> clientes = null;
		try {
			clientes = clienteDao.findAll();
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clientes;
	}

}
