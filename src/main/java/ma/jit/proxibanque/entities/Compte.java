/**
 * c'est une classe qui represente un compte
 */
package ma.jit.proxibanque.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Groupe D
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Compte implements Serializable {
	
	@Id @GeneratedValue(strategy =GenerationType.AUTO)
    private Long numCompte;
	
    private Date dateCreation;
    private double solde;
    
//    @ManyToOne
//    @JoinColumn(name="CODE_CLIENT")
//    private Client client;
    
    @OneToMany(mappedBy="compte",fetch=FetchType.LAZY)
    @JsonIgnore
    private List<Operation> operations =  new ArrayList<>();
    
    
	/**
	 * constructeur sans parametres
	 */
	public Compte() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * constructeur avec parametres
	 */
//	public Compte(Date dateCreation, double solde, Client client) {
//		super();
//		this.dateCreation = dateCreation;
//		this.solde = solde;
//		this.client = client;
//	}
	
	
	public Compte(Date dateCreation, double solde, List<Operation> operations) {
		super();
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.operations = operations;
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

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	
	

//	@JsonIgnore
//	public Client getClient() {
//		return client;
//	}
//
//	public void setClient(Client client) {
//		this.client = client;
//	}

}
