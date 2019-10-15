/**
 * 
 */
package ma.jit.proxibanque.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Groupe D
 *
 */
@Entity
public class Compte implements Serializable {
	@Id @GeneratedValue
    private Long numCompte;
    private Date dateCreation;
    private double solde;
    
    @ManyToOne
    @JoinColumn(name="CODE_CLIENT")
    private Client client;
    
    
	/**
	 * constructeur sans parametres
	 */
	public Compte() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * constructeur avec parametres
	 */
	public Compte(Date dateCreation, double solde, Client client) {
		super();
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.client = client;
	}

	public Long getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(Long numCompte) {
		this.numCompte = numCompte;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
