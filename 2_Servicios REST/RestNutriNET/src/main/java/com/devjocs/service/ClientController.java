package com.devjocs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ClientController {
	
	@Autowired
	private ClientService clientService;

	@RequestMapping("/GET/NutriNET/Cliente")
	public List<Client> getAllTopics() {
		return clientService.getAllClient();
	}
	
	@RequestMapping("/GET/NutriNET/Cliente/{c}")
	public Client getTopic(@PathVariable("c") String id) {
		return clientService.getClient(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/POST/NutriNET/Cliente")
	public void addTopic(@RequestBody Client c) {
		clientService.addClient(new Client(c.getNombre(),c.getApellidos(),c.getNombre_usuario(),c.getCorreo_electronico(),c.getContrasena()));
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/PUT/NutriNET/Cliente/{id}")
	public void updateTopic(@RequestBody Client c, @PathVariable String id) {
		clientService.updateClient(id, c);
	}
	
}
