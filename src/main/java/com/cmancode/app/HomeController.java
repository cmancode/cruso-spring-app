package com.cmancode.app;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cmancode.app.model.Cliente;
import com.cmancode.app.service.IClienteService;

@Controller
public class HomeController {
	
	
	@Autowired
	private IClienteService clienteService;
	
	@RequestMapping(value = "cliente", method = RequestMethod.GET)
	public ModelAndView viewClient(ModelAndView model) {
		Cliente cliente = new Cliente();
		model.addObject("cliente", cliente);
		model.setViewName("cliente");
		return model;
	}
	
	@RequestMapping(value = "cliente", method = RequestMethod.POST)
	public String saveClient(@Valid Cliente cliente, BindingResult result) {
		
		if(result.hasErrors()) {
			return "cliente";
		}
		clienteService.saveClient(cliente);		
		return "redirect:lista";
	}
	
	@RequestMapping(value = {"/", "/lista"}, method = RequestMethod.GET)
	public ModelAndView listar(ModelAndView model) {
		List<Cliente> clientes = null;
		clientes = clienteService.findAllClient();
		model.addObject("lista", clientes);
		model.setViewName("lista");
		return model;
	}
	
}
