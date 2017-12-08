package com.cmancode.app;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		model.addObject("encabezado", "Nuevo Cliente");
		model.addObject("boton", "Registrar Cliente");
		model.setViewName("cliente");
		return model;
	}
	
	@RequestMapping(value = "/cliente/{id}", method = RequestMethod.GET)
	public ModelAndView updateClient(@PathVariable("id") Long id, ModelAndView model) {
		Cliente cliente = null;
		if(id >0) {
			cliente = clienteService.findCliente(id);
		}else {
			model.setViewName("lista");
			return model;
		}
		model.addObject("cliente", cliente);
		model.addObject("encabezado", "Modificar datos");
		model.addObject("boton", "Actualzar datos");
		model.setViewName("cliente");
		return model;
	}
	
	@RequestMapping(value = "cliente", method = RequestMethod.POST)
	public String saveClient(@Valid Cliente cliente, BindingResult result, RedirectAttributes flash, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("encabezado", "Nuevo Cliente");
			model.addAttribute("boton", "Registrar cliente");
			return "cliente";
		}
		clienteService.saveClient(cliente);
		flash.addFlashAttribute("success", "Información registrada con éxito!");	
		return "redirect:lista";
	}
	
	@RequestMapping(value = {"/", "/lista"}, method = RequestMethod.GET)
	public String listar(Model model) {
		List<Cliente> clientes = null;
		clientes = clienteService.findAllClient();
		model.addAttribute("lista", clientes);
		return "lista";
	}
	
}
