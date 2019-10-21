/**
 * 
 */
package ma.jit.proxibanque.metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.jit.proxibanque.dao.ClientRepository;
import ma.jit.proxibanque.entities.Client;
import ma.jit.proxibanque.entities.CompteCourant;

/**
 * @author  Group D
 *
 */

/**
 * c'est la classe qui permet d'implémenter les methodes metier Client
 */
@Service
public class ClientMetierImpl implements IClientMetier {
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
	public Client ajouterClient(Client client) {

//		CompteCourant compte = new CompteCourant();
//		compte.setSolde(2000.00);
//		compte.setDateCreation(new Date());
//		compte.setClient(c);
//		c.getListeComptes().add(compte);
		

		if (client.getCompteCourant() != null)
			client.getCompteCourant().setDateCreation(new Date());

		if (client.getCompteEpargne() != null)
			client.getCompteEpargne().setDateCreation(new Date());

		return clientRepository.save(client);
	}

	@Override
	public Client modifierClient(Long id, Client c) {
		Client client = this.consulterClient(id);
		client.setNom(c.getNom());
		client.setPrenom(c.getPrenom());
		client.setAdresse(c.getAdresse());
		client.setEmail(c.getEmail());
		client.setVille(c.getVille());
		client.setCodePostale(c.getCodePostale());
		return clientRepository.save(client) ;
	}

	@Override
	public List<Client> listeClients() {
		
		return clientRepository.findAll() ;
	}

	

}
