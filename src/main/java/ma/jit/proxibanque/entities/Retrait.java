/**
 * c'est une classe qui represente les retraits
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
@DiscriminatorValue("R")
public class Retrait extends Operation implements Serializable{

	/**
	 * constructeur sans parametres
	 */
	public Retrait() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param dateOp
	 * @param montant
	 * @param crediteur
	 * @param debiteur
	 */
	public Retrait(Date dateOp, double montant, Compte debiteur) {
		super(dateOp, montant, debiteur);
		// TODO Auto-generated constructor stub
	}



}
