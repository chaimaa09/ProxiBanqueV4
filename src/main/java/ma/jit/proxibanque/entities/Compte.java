/**
 * c'est une classe qui represente un compte
 */
package ma.jit.proxibanque.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Groupe D
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_compte")
public abstract class Compte implements Serializable {
	
	@Id @GeneratedValue(strategy =GenerationType.AUTO)
    private Long numCompte;
	
    private Date dateCreation;
    private double solde;
    
    @ManyToOne
    @JoinColumn(name="CODE_CLIENT")
    private Client client;
    
    @OneToMany(mappedBy="compte",fetch=FetchType.LAZY)
    private List<Operation> operations;
    
    
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
