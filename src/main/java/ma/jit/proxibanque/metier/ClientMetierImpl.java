/**
 * 
 */
package ma.jit.proxibanque.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.jit.proxibanque.dao.ClientRepository;
import ma.jit.proxibanque.entities.Client;

/**
 * @author FOLIO Groupe D
 *
 */

/**
 * c'est la classe qui permet d'implémenter les methodes metier Client
 */
@Service
public class ClientMetierImpl implements IConseillerMetier {
	@Autowired
	ClientRepository clientRepository;
	

	@Override
	public Client consulterClient(Long codeClient) {
		
		return clientRepository.getOne(codeClient);
	}

	@Override
	public void supprimerClient(Long codeClient) {
		clientRepository.deleteById(codeClient);
		
	}

	@Override
	public Client ajouterClient(Client c) {
		
		return clientRepository.save(c);
	}

	@Override
	public Client modifierClient(Client c) {
		
		return clientRepository.save(c) ;
	}

	@Override
	public List<Client> listeClients() {
		
		return clientRepository.findAll() ;
	}

	

}
