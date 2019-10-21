/**
 * c'est une classe qui represente les versements
 */
package ma.jit.proxibanque.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author FOLIO 9740M
 *
 */
@Entity
@DiscriminatorValue("V")
public class Versement extends Operation implements Serializable {

	/**
	 * constructeur sans parametres
	 */
	
	public Versement() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param dateOp
	 * @param montant
	 * @param crediteur
	 * @param debiteur
	 */
	public Versement(Date dateOp, double montant, Compte crediteur) {
		super(dateOp, montant, crediteur);
		// TODO Auto-generated constructor stub
	}

	
	
}
