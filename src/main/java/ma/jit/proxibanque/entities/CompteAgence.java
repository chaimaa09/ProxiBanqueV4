/**
 * 
 */
package ma.jit.proxibanque.entities;

import java.util.Date;
import java.util.List;

/**
 * @author Groupe D
 *
 */
public class CompteAgence extends Compte {

	/**
	 * 
	 */
	public CompteAgence() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param dateCreation
	 * @param solde
	 * @param operations
	 */
	public CompteAgence(Date dateCreation, double solde, List<Operation> operations) {
		super(dateCreation, solde, operations);
		// TODO Auto-generated constructor stub
	}

}
