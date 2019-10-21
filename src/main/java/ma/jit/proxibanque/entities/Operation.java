/**
 * c'est une classe abstrait qui represente les operations
 */
package ma.jit.proxibanque.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Groupe D
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Operation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy =GenerationType.AUTO)
	private Long numero ;
	
	private Date dateOp;
	private double montant;
	
	@ManyToOne
	@JoinColumn(name="code_crediteur")
	private Compte crediteur;
	
	@ManyToOne
	@JoinColumn(name="code_debiteur")
	private Compte debiteur;
	
	
	/**
	 * constructeur sans parametres
	 */
	public Operation() {
		// TODO Auto-generated constructor stub
	}
	
	



	/**
	 * @param dateOp
	 * @param montant
	 * @param debiteur
	 */
	public Operation(Date dateOp, double montant, Compte compte) {
		super();
		this.dateOp = dateOp;
		this.montant = montant;
		this.debiteur = compte;
	}


	/**
	 * @return the numero
	 */
	public Long getNumero() {
		return numero;
	}
	/**
	 * @param numero the numero to set
	 */
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	/**
	 * @return the dateOp
	 */
	public Date getDateOp() {
		return dateOp;
	}
	/**
	 * @param dateOp the dateOp to set
	 */
	public void setDateOp(Date dateOp) {
		this.dateOp = dateOp;
	}
	/**
	 * @return the montant
	 */
	public double getMontant() {
		return montant;
	}
	/**
	 * @param montant the montant to set
	 */
	public void setMontant(double montant) {
		this.montant = montant;
	}
	/**
	 * @return the crediteur
	 */
	public Compte getCrediteur() {
		return crediteur;
	}
	/**
	 * @param crediteur the crediteur to set
	 */
	public void setCrediteur(Compte crediteur) {
		this.crediteur = crediteur;
	}
	/**
	 * @return the debiteur
	 */
	public Compte getDebiteur() {
		return debiteur;
	}
	/**
	 * @param debiteur the debiteur to set
	 */
	public void setDebiteur(Compte debiteur) {
		this.debiteur = debiteur;
	}


	
}
