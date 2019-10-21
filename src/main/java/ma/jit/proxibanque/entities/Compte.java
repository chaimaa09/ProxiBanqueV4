/**
 * c'est une classe qui represente un compte
 */
package ma.jit.proxibanque.entities;

import java.io.Serializable;
import java.util.ArrayList;
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

import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Groupe D
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name="type_compte")
public abstract class Compte implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy =GenerationType.AUTO)
    private int numCompte;
	
    private Date dateCreation;
    private double solde;
    
//    @ManyToOne
//    @JoinColumn(name="CODE_CLIENT")
//    private Client client;
    
    @OneToMany(mappedBy="crediteur")
    @JsonIgnore
    private List<Operation> versement =  new ArrayList<>();
    
    @OneToMany(mappedBy="debiteur")
    @JsonIgnore
    private List<Operation> retrait =  new ArrayList<>();
    
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
	
	
	
	
	public int getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(int numCompte) {
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

	/**
	 * @return the versement
	 */
	public List<Operation> getVersement() {
		return versement;
	}

	/**
	 * @param versement the versement to set
	 */
	public void setVersement(List<Operation> versement) {
		this.versement = versement;
	}

	/**
	 * @return the retrait
	 */
	public List<Operation> getRetrait() {
		return retrait;
	}

	/**
	 * @param retrait the retrait to set
	 */
	public void setRetrait(List<Operation> retrait) {
		this.retrait = retrait;
	}

	/**
	 * @param dateCreation
	 * @param solde
	 * @param versement
	 * @param retrait
	 */
	public Compte(Date dateCreation, double solde, List<Operation> versement, List<Operation> retrait) {
		super();
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.versement = versement;
		this.retrait = retrait;
	}

	/**
	 * @param numCompte
	 * @param dateCreation
	 * @param solde
	 * @param versement
	 * @param retrait
	 */
	public Compte(int numCompte, Date dateCreation, double solde, List<Operation> versement, List<Operation> retrait) {
		super();
		this.numCompte = numCompte;
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.versement = versement;
		this.retrait = retrait;
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
