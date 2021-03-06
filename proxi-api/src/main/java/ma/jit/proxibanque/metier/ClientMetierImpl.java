/**
 * 
 */
package ma.jit.proxibanque.metier;

import java.util.Date;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.jit.proxibanque.dao.ClientRepository;
import ma.jit.proxibanque.dao.ConseillerRepository;

import ma.jit.proxibanque.dao.ParametrageRepository;

import ma.jit.proxibanque.entities.Client;
import ma.jit.proxibanque.entities.Compte;
import ma.jit.proxibanque.entities.CompteCourant;
import ma.jit.proxibanque.entities.Conseiller;

import ma.jit.proxibanque.entities.Parametrage;


/**
 * @author  Groupe D
 *
 */

/**
 * c'est la classe qui permet d'implémenter les methodes metier Client
 */
@Service
public class ClientMetierImpl implements IClientMetier {
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	ConseillerRepository conseillerRepository ;
	
	@Autowired
	ParametrageRepository parametrageRepository;
	
	
	
	/**cette methode sert a consulter un client
	 * 
	 */
	@Override
	public Client consulterClient(Long codeClient) {
		
		return clientRepository.getOne(codeClient);
	}

	/**cette methode sert a supprimer un client
	 * 
	 */
	@Override
	public void supprimerClient(Long codeClient) {
		clientRepository.deleteById(codeClient);
		
	}

	/**cette methode sert a ajouter un client
	 * 
	 */
	@Override
	public Client ajouterClient(Client client) {


		Parametrage parametrage = parametrageRepository.findById(0L).get();
       Conseiller conseiller = conseillerRepository.findById(10L).get();     

        if(conseiller.getClient().size() < parametrage.getNombreMaxClient() ) {
        CompteCourant compte = new CompteCourant();
        if(client.getCompteCourant().getSolde()>20) {
        compte.setSolde(client.getCompteCourant().getSolde());
        compte.setDateCreation(new Date());
        client.addCompte(compte);
        conseiller.getClient().add(client);
       client.setConseiller(conseiller);
        if (client.getCompteEpargne() != null)
			client.getCompteEpargne().setDateCreation(new Date());
        return clientRepository.save(client);
        }
        else {
            return client;
        }
        }
		return client;}
        

	

	/**cette methode sert a modifier un client
	 * 
	 */
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

	/**cette methode sert a lister la liste des clients
	 * 
	 */
	@Override
	public List<Client> listeClients() {
		List<Client> listeClients=clientRepository.findAll() ;
		System.out.println("get data "+listeClients);
		return listeClients;
		
	}
	
	/**cette methode sert a affecter un client
	 * 
	 */
	@Override
	public void affecterClient(long idClient, long idConseiller) {
		Conseiller conseiller = conseillerRepository.findById(idConseiller).get();
		Client client = clientRepository.findById(idClient).get();
		client.getConseiller().getClient().remove(client);
		conseiller.getClient().add(client);
		client.setConseiller(conseiller);
		clientRepository.save(client);
		
	}

	

}
