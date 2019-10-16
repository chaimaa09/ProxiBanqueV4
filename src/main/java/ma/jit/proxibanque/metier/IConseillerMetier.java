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
public interface IConseillerMetier {
	public Client consulterClient(Long codeClient);
	public void supprimerClient(Long codeClient);
	public Client ajouterClient(Client c);
	public Client modifierClient(Client c);
	public List<Client> listeClients() ;
	
	
}
