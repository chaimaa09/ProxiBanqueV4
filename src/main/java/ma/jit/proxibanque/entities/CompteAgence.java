/**
 * 
 */
package ma.jit.proxibanque.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author Groupe D
 *
 */
public class CompteAgence extends Compte {

	@OneToOne
	@JoinColumn(name = "idAgence")
	@JsonBackReference
	private Agence agence;
	
	/**
	 * 
	 */
	public CompteAgence() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the agence
	 */
	public Agence getAgence() {
		return agence;
	}

	/**
	 * @param agence the agence to set
	 */
	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	/**
	 * @param dateCreation
	 * @param solde
	 * @param operations
	 */
	public CompteAgence(Date dateCreation, double solde, List<Operation> operations) {
		super(dateCreation, solde, operations);
		
	}
	
	

}
