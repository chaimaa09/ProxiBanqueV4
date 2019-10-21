/**
 * c'est une classe qui represente un compte epargne
 */
package ma.jit.proxibanque.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author Groupe D
 *
 */
@Entity
public class CompteEpargne extends Compte {

	private final double tauxRemuneration =0.03;
	
	@OneToOne
	@JoinColumn(name = "code")
	@JsonBackReference
	private Client client;
	
	/**
	 * @return the tauxRemuneration
	 */
	public double getTauxRemuneration() {
		return tauxRemuneration;
	}

	/**
	 * constructeur sans parametres
	 */
	public CompteEpargne() {
		// TODO Auto-generated constructor stub
	}

	

	/**
	 * constructeur avec parametres
	 * @param dateCreation
	 * @param solde
	 * @param client
	 */
//	public CompteEpargne(Date dateCreation, double solde, Client client) {
//		super(dateCreation, solde, client);
//		// TODO Auto-generated constructor stub
//	}
	
	public CompteEpargne(Date dateCreation, double solde, List<Operation> operations) {
		super(dateCreation, solde, operations);
		// TODO Auto-generated constructor stub
	}

	public CompteEpargne(Client client) {
		super();
		this.client = client;
	}
	
	
	
	
	

}
