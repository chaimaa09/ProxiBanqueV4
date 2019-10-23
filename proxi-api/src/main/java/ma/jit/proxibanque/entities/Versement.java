/**
 * c'est une classe qui represente les versements
 */
package ma.jit.proxibanque.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Groupe D
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
	 * @param compte
	 */
	public Versement(Date dateOp, double montant, Compte compte) {
		super(dateOp, montant, compte);
		// TODO Auto-generated constructor stub
	}

}
