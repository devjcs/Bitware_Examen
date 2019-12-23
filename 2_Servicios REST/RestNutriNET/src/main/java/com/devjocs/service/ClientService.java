package com.devjocs.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ClientService {

	private List<Client> clients = new ArrayList<>(Arrays.asList(
			new Client("59", "joel", "cadena", "devjocs", "micorreo@gmail.com", "joelcadena", "39", "1.80" ,"60", "1500")));

	public List<Client> getAllClient(){
		return clients;
	}
	
	public Client getClient(String id) {
		return clients.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addClient(Client client) {
		clients.add(client);
	}

	public void updateClient(String id, Client client) {
		
		for(int i = 0; i < clients.size(); i++) {
			Client c = clients.get(i);
			if(c.getId().equals(id)) {
				c.setEstatura(client.getEstatura());
				c.setPeso(client.getPeso());
				clients.set(i, c);
				return;
			}
		}
	}

}
