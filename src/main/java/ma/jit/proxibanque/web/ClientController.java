/**
 * 
 */
package ma.jit.proxibanque.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.jit.proxibanque.entities.Client;
import ma.jit.proxibanque.metier.IClientMetier;

/**
 * @author Groupe D
 *
 */
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ClientController {
	
	@Autowired
	IClientMetier clientService;
	
	@GetMapping("/clients")
	public List<Client> getAll(){
		return clientService.listeClients();
	}
	
	@GetMapping("/clients/{id}")
	public Client getClientById(@PathVariable(value = "id") Long id) {
		return clientService.consulterClient(id);
	}
	
	@PostMapping("/clients")
	public Client addClient(@RequestBody Client client) {
		return clientService.ajouterClient( client);
	}
	
	@DeleteMapping("/clients/{id}")
	public void deleteClient(@PathVariable(value = "id") Long id) {
		clientService.supprimerClient(id);
	}
	
	@PutMapping("/clients/{id}")
	public Client updateClient(@PathVariable(value="id") Long id,@RequestBody Client client) {
		//Client client = getClientById(id);
		return clientService.modifierClient(id, client);
	}
	
}
