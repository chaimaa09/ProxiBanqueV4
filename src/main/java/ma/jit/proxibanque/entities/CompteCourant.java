/**
 * c'est une classe qui represente un compte courant
 */
package ma.jit.proxibanque.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
/**
 * @author Groupe D
 *
 */
@Entity
public class CompteCourant extends Compte implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final double decouvert = 1000;

	public double getDecouvert() {
		return decouvert;
	}
	
	@OneToOne

	@JoinColumn(name = "code_client")
	@JsonBackReference
	private Client client;

	
	/**
	 * constructeur sans parametres
	 */
	public CompteCourant() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * constructeur avec parametres
	 */
//	public CompteCourant(Date dateCreation, double solde, Client client) {
//		super(dateCreation, solde, client);
//		// TODO Auto-generated constructor stub
//	}
	
	

	
	
	
	public CompteCourant(Client client) {
		super();
		this.client = client;
	}
	/**
	 * @param dateCreation
	 * @param solde
	 * @param versement
	 * @param retrait
	 */
	public CompteCourant(Date dateCreation, double solde, List<Operation> versement, List<Operation> retrait) {
		super(dateCreation, solde, versement, retrait);

	}

	
	

	/**
	 * @param numCompte
	 * @param dateCreation
	 * @param solde
	 * @param versement
	 * @param retrait
	 */
	public CompteCourant(int numCompte, Date dateCreation, double solde, List<Operation> versement,
			List<Operation> retrait) {
		super(numCompte, dateCreation, solde, versement, retrait);

	}
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	

}
