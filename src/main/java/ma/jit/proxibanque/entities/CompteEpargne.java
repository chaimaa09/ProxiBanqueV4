/**
 * c'est une classe qui represente un compte epargne
 */
package ma.jit.proxibanque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Groupe D
 *
 */
@Entity
@DiscriminatorValue("ce")
public class CompteEpargne extends Compte {

	private final double tauxRemuneration =0.03;
	
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
	public CompteEpargne(Date dateCreation, double solde, Client client) {
		super(dateCreation, solde, client);
		// TODO Auto-generated constructor stub
	}

}
