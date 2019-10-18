package ma.jit.proxibanque.metier;

import java.util.List;
import ma.jit.proxibanque.entities.Client;

/**
 * @author FOLIO Groupe D
 *
 */

/**
 * c'est l'interfece des methodes metier Client
 */
public interface IClientMetier {
	
	public Client consulterClient(Long code);
	public void supprimerClient(Long code);
	public Client ajouterClient(Client c);
	public Client modifierClient(Long code, Client c);
	public List<Client> listeClients() ;
	
	
}
