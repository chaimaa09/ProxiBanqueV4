/**
 * c'est une classe qui represente un compte courant
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
@DiscriminatorValue("cc")
public class CompteCourant extends Compte implements Serializable{
	
	private final double decouvert = 1000;

	public double getDecouvert() {
		return decouvert;
	}

	
	/**
	 * constructeur sans parametres
	 */
	public CompteCourant() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * constructeur avec parametres
	 */
	public CompteCourant(Date dateCreation, double solde, Client client) {
		super(dateCreation, solde, client);
		// TODO Auto-generated constructor stub
	}

}
